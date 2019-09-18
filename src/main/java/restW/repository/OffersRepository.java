package restW.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restW.model.Genre;
import restW.model.Offers;

public interface OffersRepository extends JpaRepository<Offers, Integer> {
}
