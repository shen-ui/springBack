package api.victorxie.blog.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.stream;

@RestController
@RequestMapping(path = "api/v1/authors")
public class AuthorController {
    private final AuthorService authorService;
    @Autowired
    public AuthorController(AuthorService authorService) { this.authorService = authorService; }
    @GetMapping( path = "/all")
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }
    @GetMapping( path = "/authors/{username}")
    public Author getAuthors(@PathVariable String username){
        List<Author> authors = authorService.getAuthors();
        Optional<Author> authorOptional = authors.stream().filter(a -> a.getUsername().equals(username)).findFirst();
        authorOptional.toString();
        return authorOptional.orElseThrow();
    }
}