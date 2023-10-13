package api.victorxie.blog.Author;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @RestController: Makes endpoints restful with @GetMapping/@PutMapping/@PostMapping/@DeleteMapping
 */
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

    @PutMapping(path = "/update/{author_id}")
    public void updateAuthor(@PathVariable("author_id") Long id,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) String email,
                             @RequestParam(required = false) String username,
                             @RequestParam(required = false) String password){
        authorService.updateAuthor(id, name, email, username, password);
    }

}