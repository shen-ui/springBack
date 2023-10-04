package api.victorxie.blog.Blog;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Entity
@Table
public class Post {
    @Setter
    @jakarta.persistence.Id
    @Id
    @SequenceGenerator(
            name="post_sequence",
            sequenceName= "post_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="post_sequence"
    )
    private Long id;
    @Setter @Getter private String title;
    @Setter @Getter private String entry;
    @Getter private ZonedDateTime date;
    private UUID blog_id;
    public Post(){}
    public Post(Long id, String entry, String title){
        setId(id);
        setEntry(entry);
        setTitle(title);
        setDate();
        setBlogID();
    }

    public void setDate(){ this.date = ZonedDateTime.now(); }
    public void setBlogID(){ this.blog_id = UUID.randomUUID(); }

    public void updateEntry(String entry, String title){
        if(!this.title.equals(title)) setTitle(title);
        if(!this.entry.equals(entry)) setEntry(entry);
        if(!this.title.equals(title) && !this.entry.equals(entry)) setDate();
    }
    @Override
    public String toString() {
        return (
                "ID: " + getId() + "\n" +
                        "Title: " + getTitle() + "\n" +
                        "Entry: " + getEntry() + "\n" +
                        "Date: " + getDate() + "\n"
        );
    }
}
