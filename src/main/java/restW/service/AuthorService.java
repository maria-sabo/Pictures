package restW.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import restW.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restW.model.Author;
import restW.repository.AuthorRepository;

import java.util.List;

@Slf4j
@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author getById(Integer id) {
        return authorRepository.findOne(id);
    }

    public List<Author> getByName(String name) {
        String percent_name = "%" + name + "%";
        return authorRepository.getByName(percent_name);
    }

    public void save(Author author) {
        authorRepository.save(author);
    }

    public void delete(Integer id) {
        authorRepository.delete(id);
    }

    public List<Author> getAll() {
        return authorRepository.findAll();
    }
}
