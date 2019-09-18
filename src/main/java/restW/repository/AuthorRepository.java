package restW.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import restW.model.Author;
import restW.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import restW.model.Genre;
import restW.model.Picture;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
   @Query(value = "select * from author where name ilike :name", nativeQuery = true)
   List<Author> getByName(@Param("name") String name);
}


