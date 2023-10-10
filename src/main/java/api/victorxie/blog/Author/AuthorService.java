package api.victorxie.blog.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    @Autowired
    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthors(){
        return(authorRepository.findAll());
    }
    public void addNewAuthor(Author author){
        Optional<Author> authorOptional = authorRepository.findAuthorByEmail(author.getEmail());
        if(authorOptional.isPresent()){
            throw new IllegalStateException("Email has an account. Try logging in.");
        }
        authorRepository.save(author);
    }

    public void removeAuthor(Long author_id) {
        boolean exists = authorRepository.existsById(author_id);
        if (!exists) {
            throw new IllegalStateException("Author with ID " + author_id + " does not exist.");
        }
        authorRepository.deleteById(author_id);
    }

}