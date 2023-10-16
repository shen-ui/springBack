package api.victorxie.blog.OAuth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuthController {
    @GetMapping( path = "api/v1/oauth")
    public String login(){
        return ("login unsecure");
    }
    @GetMapping( path = "api/v1/oauth/secure")
    public String loginSecure(){
        return("login secure");
    }
}
