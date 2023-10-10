package api.victorxie.blog.Author;

import jakarta.transaction.Transactional;
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
    @Transactional
    public void updateAuthor(Long id, String name, String email, String username, String password){
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Author with id " + id + " does not exist."));

        if(name != null &&
                !name.isEmpty() &&
                !name.equals(author.getAuthor_name())){
            author.setAuthor_name(name);
        }
        if(email != null &&
                !email.isEmpty() &&
                !email.equals(author.getEmail())){
            author.setEmail(email);
        }
        if(username != null &&
                !username.isEmpty() &&
                !username.equals(author.getUsername())){
            author.setUsername(username);
        }
        if(password != null &&
                !password.isEmpty() &&
                !password.equals(author.getPassword())){
            author.setPassword(password);
        }
    }
}