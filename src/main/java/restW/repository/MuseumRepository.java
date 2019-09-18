package restW.repository;

import restW.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import restW.model.Genre;

public interface MuseumRepository extends JpaRepository<Museum, Integer> {
}