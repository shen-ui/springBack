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
    public AuthorController(AuthorService authorService) { this.authorService = authorService; }
    @GetMapping( path = "/authors")
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }
    @GetMapping( path = "/authors/{username}")
    public ResponseEntity<Author> getAuthors(@PathVariable String username){
        List<Author> authors = authorService.getAuthors();
        Optional<Author> authorOptional = authors.stream().filter(a -> a.getUsername().equals(username)).findFirst();
        return authorOptional.map(author -> new ResponseEntity<>(author, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
    /*@PutMapping("/author/new/{author_name}/{username}/{email}/{password}/")
    public Author putAuthor(
            @PathVariable String author_name,
            @PathVariable String username,
            @PathVariable String  email,
            @PathVariable String password
    ) {
        Author newUser = authorRepository.getOne();
    }*/
}