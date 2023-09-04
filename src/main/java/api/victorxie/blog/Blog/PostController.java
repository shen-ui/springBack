package api.victorxie.blog.Blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/", method = RequestMethod.GET)
public class PostController {
    private final PostService postService;

    /**
     * @Autowired should autowire PostService to this postService
     * @param postService: the postService above should inject to the local postService
     */
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping( path = "/posts")
    public List<Post> getPosts(){
        return postService.getPosts();
    }
}
