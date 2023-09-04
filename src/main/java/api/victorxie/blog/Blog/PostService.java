package api.victorxie.blog.Blog;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PostService {
    public List<Post> getPosts(){
        return (List.of(
                new Post(1L, "entry", "title"),
                new Post(2L, "entry", "title")
        ));
    }
}
