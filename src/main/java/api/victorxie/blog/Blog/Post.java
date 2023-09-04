package api.victorxie.blog.Blog;

import org.springframework.data.annotation.Id;
import java.time.ZonedDateTime;
public class Post {
    private Long id;
    private String title;
    private String entry;
    private ZonedDateTime date;
    public Post(Long id, String entry, String title){
        setId(id);
        setEntry(entry);
        setTitle(title);
        setDate();
    }
    public void setId(Long id){
        this.id = id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setEntry(String entry){
        this.entry = entry;
    }
    public void setDate(){
        this.date = ZonedDateTime.now();
    }
    public Long getId(){ return (this.id); }
    public String getEntry(){ return (this.entry); }
    public String getTitle(){ return (this.title); }
    public ZonedDateTime getDate(){ return (this.date); }
    public void updateEntry(String entry, String title){
        if(!this.title.equals(title)) setTitle(title);
        if(!this.entry.equals(entry)) setEntry(entry);
        if(!this.title.equals(title) && !this.entry.equals(entry)) setDate();
    }
    @Override
    public String toString(){
        return(
            "ID: "    + getId()    + "\n" +
            "Title: " + getTitle() + "\n" +
            "Entry: " + getEntry() + "\n" +
            "Date: "  + getDate()  + "\n"
        );
    }
}
