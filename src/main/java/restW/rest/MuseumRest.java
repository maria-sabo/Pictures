package restW.rest;

import org.springframework.web.servlet.ModelAndView;
import restW.model.Museum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import restW.service.MuseumService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/museum")

public class MuseumRest {

    @Autowired
    private MuseumService museumService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Museum> getmuseum(@PathVariable("id") Integer museumId) {
        if (museumId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Museum museum = this.museumService.getById(museumId);
        if (museum == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(museum, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Museum> save(@RequestBody @Valid Museum museum) {
        HttpHeaders headers = new HttpHeaders();
        if (museum == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.museumService.save(museum);
        return new ResponseEntity<>(museum, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Museum> update(@RequestBody @Valid Museum museum, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();
        if (museum == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.museumService.save(museum);
        return new ResponseEntity<>(museum, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Museum> deleteE(@PathVariable("id") Integer id) {
        Museum museum = this.museumService.getById(id);
        if (museum == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.museumService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Museum>> getAllE() {
        List<Museum> museums = this.museumService.getAll();
        if (museums.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(museums, HttpStatus.OK);
    }
}
