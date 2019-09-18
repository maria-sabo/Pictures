package restW.repository;

import org.springframework.data.jpa.repository.Query;
import restW.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import restW.model.Genre;

public interface PictureRepository extends JpaRepository<Picture, Integer> {
}