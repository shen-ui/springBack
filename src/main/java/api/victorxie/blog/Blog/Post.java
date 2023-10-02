package api.victorxie.blog.Blog;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import java.time.ZonedDateTime;
@Getter
@Entity
@Table
public class Post {
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
    private String title;
    private String entry;
    private ZonedDateTime date;
    public Post(){}
    public Post(Long id, String entry, String title){
        setId(id);
        setEntry(entry);
        setTitle(title);
        setDate();
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setEntry(String entry){
        this.entry = entry;
    }
    public void setDate(){ this.date = ZonedDateTime.now(); }
    public void setId(Long id) { this.id = id; }
    public String getEntry(){ return (this.entry); }
    public String getTitle(){ return (this.title); }
    public ZonedDateTime getDate(){ return (this.date); }
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
