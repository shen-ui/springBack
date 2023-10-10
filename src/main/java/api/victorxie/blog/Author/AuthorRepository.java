package api.victorxie.blog.Author;

import api.victorxie.blog.Author.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository @Component
public interface AuthorRepository extends JpaRepository<Author, Long> {
//   @Query("SELECT a FROM Author a WHERE a.email = ?1")
    Optional<Author> findAuthorByEmail(String email);
    Optional<Author> findAuthorByUsername(String username);
}