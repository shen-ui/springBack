package api.victorxie.blog.Author;

import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class AuthorService {
    public List<Author> getAuthors(){
        return(List.of(
                new Author("Shen Wang", "shenui", "mail@mail.com", "2018JFType!")
        ));
    }
}
