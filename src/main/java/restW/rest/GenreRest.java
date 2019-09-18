package restW.rest;

import org.springframework.web.servlet.ModelAndView;
import restW.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import restW.service.GenreService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/genre")

public class GenreRest {

    @Autowired
    private GenreService genreService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Genre> getGenre(@PathVariable("id") Integer genreId) {
        if (genreId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Genre genre = this.genreService.getById(genreId);
        if (genre == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
         return new ResponseEntity<>(genre, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Genre> save(@RequestBody @Valid Genre genre) {
        HttpHeaders headers = new HttpHeaders();
        if (genre == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.genreService.save(genre);
        return new ResponseEntity<>(genre, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Genre> update(@RequestBody @Valid Genre genre, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();
        if (genre == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.genreService.save(genre);
        return new ResponseEntity<>(genre, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Genre> deleteE(@PathVariable("id") Integer id) {
        Genre genre = this.genreService.getById(id);
        if (genre == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.genreService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Genre>> getAllE() {
        List<Genre> genres = this.genreService.getAll();
        if (genres.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(genres, HttpStatus.OK);
    }
}
