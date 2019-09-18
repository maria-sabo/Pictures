package restW.repository;

import restW.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import restW.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}

