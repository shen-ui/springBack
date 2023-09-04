package api.victorxie.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @RestController: Makes endpoints restful with @GetMapping/@PutMapping/@PostMapping/@DeleteMapping
 */
@SpringBootApplication
public class BlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
}
