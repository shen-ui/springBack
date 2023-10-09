package api.victorxie.blog.Author;

import api.victorxie.blog.Author.AuthorRepository;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class AuthorService {
    private AuthorRepository authorRepository;
    public List<Author> getAuthors(AuthorRepository authorRepository){
        return(authorRepository.findAll());


    }
}
