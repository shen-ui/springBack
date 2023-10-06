package api.victorxie.blog.Author;

import api.victorxie.blog.Author.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository @Component
public interface AuthorRepository extends JpaRepository<Author, Long> {}