package api.victorxie.blog.OAuth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuthController {
    @GetMapping( path = "/")
    public String login(){
        return ("login unsecure");
    }
    @GetMapping( path = "/secured")
    public String loginSecure(){
        return("login secure");
    }
}
