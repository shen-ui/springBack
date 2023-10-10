package api.victorxie.blog.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1")
public class AuthorController {
    private final AuthorService authorService;
    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @GetMapping( path = "/authors")
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }
    @GetMapping( path = "/authors/{username}")
    public ResponseEntity<Author> getAuthors(@PathVariable String username){
        List<Author> authors = authorService.getAuthors();
        Optional<Author> authorOptional = authors.stream().filter(a -> a.getUsername().equals(username)).findFirst();
        return authorOptional.map(author ->
                new ResponseEntity<>(author, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
    @PostMapping(path = "/new")
    // Request body takes a json blob
    public void registerNewAuthor(@RequestBody Author author) {
        authorService.addNewAuthor(author);
    }

    @DeleteMapping(path = "/delete/{author_id}")
    public void deleteAuthor(@PathVariable ("author_id") Long id) {
        authorService.removeAuthor(id);
    }
}