package api.victorxie.blog.Author;
import api.victorxie.blog.Blog.Post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@Entity
@Table
public class Author {
    @Setter
    @jakarta.persistence.Id
    @Id
    @SequenceGenerator(
            name="author_sequence",
            sequenceName= "author_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="author_sequence"
    )
    private Long id;
    @Setter @Getter private String author_name;
    @Setter @Getter private String username;
    @Setter @Getter private String email;
    @Setter private String password;
    @OneToMany(mappedBy = "author")
    @Setter @Getter private List<Post> blog;
    @Transient
    private Integer post_count;
    public Author(){}
    public Author(String author_name, String username, String email, String password) {
        setAuthor_name(author_name);
        setUsername(username);
        setEmail(email);
        setPassword(password);
    }

    public Integer getPost_count() {
        return(this.blog.size());
    }

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
                "name: " + getAuthor_name() + "\n"
        );
    }
}
