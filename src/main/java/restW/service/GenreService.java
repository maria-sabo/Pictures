package restW.service;

import lombok.extern.slf4j.Slf4j;
import restW.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restW.repository.GenreRepository;

import java.util.List;


@Slf4j
@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public Genre getById(Integer id) {
        return genreRepository.findOne(id);
    }

    public void save(Genre genre) {
        genreRepository.save(genre);
    }

    public void delete(Integer id) {
        genreRepository.delete(id);
    }

    public List<Genre> getAll() {
        return genreRepository.findAll();
    }
}
