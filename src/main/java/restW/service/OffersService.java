package restW.service;

import lombok.extern.slf4j.Slf4j;
import restW.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restW.model.Offers;
import restW.model.Offers;
import restW.repository.OffersRepository;
import restW.repository.OffersRepository;

import java.util.List;

@Slf4j
@Service
public class OffersService {

    @Autowired
    private OffersRepository offersRepository;

    public Offers getById(Integer id) {
        return offersRepository.findOne(id);
    }

    public void save(Offers offers) {
        offersRepository.save(offers);
    }

    public void delete(Integer id) {
        offersRepository.delete(id);
    }

    public List<Offers> getAll() {
        return offersRepository.findAll();
    }
}
