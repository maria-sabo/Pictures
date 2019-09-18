package restW.service;

import lombok.extern.slf4j.Slf4j;
import restW.model.Auction;
import restW.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restW.model.Picture;
import restW.repository.PictureRepository;

import java.util.List;

@Slf4j
@Service
public class PictureService {

    @Autowired
    private PictureRepository pictureRepository;

    public Picture getById(Integer id) {
        return pictureRepository.findOne(id);
    }

    public void save(Picture picture) {
        pictureRepository.save(picture);
    }

    public void delete(Integer id) {
        pictureRepository.delete(id);
    }

    public List<Picture> getAll() {
        return pictureRepository.findAll();
    }
}
