package restW.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import restW.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import restW.model.Genre;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public interface PictureMuseumRepository extends JpaRepository<PictureMuseum, Integer> {
}