package restW.service;

import lombok.extern.slf4j.Slf4j;
import restW.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restW.model.Museum;
import restW.model.Museum;
import restW.repository.MuseumRepository;
import restW.repository.MuseumRepository;

import java.util.List;

@Slf4j
@Service
public class MuseumService {

    @Autowired
    private MuseumRepository museumRepository;

    public Museum getById(Integer id) {
        return museumRepository.findOne(id);
    }

    public void save(Museum museum) {
        museumRepository.save(museum);
    }

    public void delete(Integer id) {
        museumRepository.delete(id);
    }

    public List<Museum> getAll() {
        return museumRepository.findAll();
    }
}
