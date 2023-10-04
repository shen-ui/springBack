package api.victorxie.blog.Author;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.UUID;

public class Author {
    @jakarta.persistence.Id
    @Id
    @SequenceGenerator(
            name="user_sequence",
            sequenceName= "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="user_sequence"
    )
    private long id;
    @Setter @Getter private String author_name;
    @Setter @Getter  private String username;
    @Setter @Getter private String email;
    @Setter private String password;
    private UUID blog_id;

    // Empty constructor
    public Author(){}
    public Author(String author_name, String username, String email, String password) {
        setAuthor_name(author_name);
        setUsername(username);
        setEmail(email);
        setPassword(password);
        setBlogID();
    }

    public void setBlogID(){ this.blog_id = UUID.randomUUID(); }

    public String getBlog_id() { return(this.blog_id.toString()); }
    public void updateAuthor(String username, String password, String email){
        if(!this.username.equals(username)) setUsername(username);
        if(!this.password.equals(password)) setPassword(password);
        if(!this.email.equals(email)) setEmail(email);
    }
    @Override
    public String toString(){
        return(
                "username: " + getUsername() + "\n" +
                "email: " + getEmail() + "\n" +
                "name: " + getAuthor_name() + "\n" +
                "blog ID: " + getBlog_id()
        );
    }
}
