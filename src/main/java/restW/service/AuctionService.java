package restW.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restW.model.Auction;
import restW.repository.AuctionRepository;

import java.util.List;
@Slf4j
@Service
public class AuctionService {
    @Autowired
    private AuctionRepository auctionRepository;

    public Auction getById(Integer id) {
        return auctionRepository.findOne(id);
    }

    public Auction save(Auction auction) { return auctionRepository.save(auction);
    }

    public void delete(Integer id) {
        auctionRepository.delete(id);
    }

    public List<Auction> getAll() {
        return auctionRepository.findAll();
    }

}
