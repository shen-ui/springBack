package api.victorxie.blog.Author;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AuthorConfig {
    @Bean
    CommandLineRunner commandLineRunner(AuthorRepository authorRepository) {
        return args -> {
            Author shen = new Author("shen wang", "shenui", "email1@email.com", "password1");
            Author vic = new Author("victor xie", "xievictor", "email2@email.com", "password2");
            authorRepository.saveAll(
                    List.of(shen, vic)
            );
        };
    }
}
