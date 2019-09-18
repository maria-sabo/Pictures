package restW.rest;

import org.apache.catalina.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import restW.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import restW.service.AuthorService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.xml.soap.Node;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/author")

public class AuthorRest {

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Author> getAuthor(@PathVariable("id") Integer authorId) {
        if (authorId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Author author = this.authorService.getById(authorId);
        if (author == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @RequestMapping(value = {"/search/", "/search"}, method = RequestMethod.GET)
    public ResponseEntity<List<Author>> search(
            @RequestParam Map<String, String> allRequestParams, ModelMap model) {
        Iterator it = allRequestParams.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry pair = (Map.Entry) it.next();
            if (pair.getKey().equals("name")) {
                List<Author> authors = this.authorService.getByName(pair.getValue().toString());
                return new ResponseEntity<>(authors, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Author> save(@RequestBody @Valid Author author) {
        HttpHeaders headers = new HttpHeaders();
        if (author == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.authorService.save(author);
        return new ResponseEntity<>(author, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Author> update(@RequestBody @Valid Author author, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();
        if (author == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.authorService.save(author);

        return new ResponseEntity<>(author, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Author> deleteE(@PathVariable("id") Integer id) {
        Author author = this.authorService.getById(id);
        if (author == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.authorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Author>> getAllE() {
        List<Author> authors = this.authorService.getAll();
        if (authors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }
}
