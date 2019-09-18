package restW.service;

import lombok.extern.slf4j.Slf4j;
import restW.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restW.repository.AuctionRepository;
import restW.repository.PictureMuseumRepository;
import restW.repository.PictureRepository;
//import restW.repository.QpmRepository;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Slf4j
@Service
public class PictureMuseumService{

    @Autowired
    @Resource
    private PictureMuseumRepository pictureMuseumRepository;

    public PictureMuseum getById(Integer id) {
        return pictureMuseumRepository.findOne(id);
    }

    public void save(PictureMuseum pictureMuseum) {
        pictureMuseumRepository.save(pictureMuseum);
    }

    public void delete(Integer id) {
        pictureMuseumRepository.delete(id);
    }

    public List<PictureMuseum> getAll() {
        return pictureMuseumRepository.findAll();
    }
}
