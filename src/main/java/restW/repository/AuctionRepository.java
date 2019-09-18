package restW.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import restW.model.Auction;
import restW.model.Author;

public interface AuctionRepository extends JpaRepository<Auction, Integer> {
}
