package restW.rest;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import restW.model.*;
import restW.model.PictureMuseum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import restW.service.PictureMuseumService;

import javax.validation.Valid;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pictureMuseum")

public class PictureMuseumRest {

    @Autowired
    private PictureMuseumService pictureMuseumService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PictureMuseum> getPictureMuseum(@PathVariable("id") Integer pictureMuseumId) {
        if (pictureMuseumId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        PictureMuseum pictureMuseum = this.pictureMuseumService.getById(pictureMuseumId);
        if (pictureMuseum == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pictureMuseum, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PictureMuseum> save(@RequestBody @Valid PictureMuseum pictureMuseum) {
        HttpHeaders headers = new HttpHeaders();

        if (pictureMuseum == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.pictureMuseumService.save(pictureMuseum);
        return new ResponseEntity<>(pictureMuseum, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PictureMuseum> update(@RequestBody @Valid PictureMuseum pictureMuseum, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (pictureMuseum == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.pictureMuseumService.save(pictureMuseum);

        return new ResponseEntity<>(pictureMuseum, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PictureMuseum> deleteE(@PathVariable("id") Integer id) {
        PictureMuseum pictureMuseum = this.pictureMuseumService.getById(id);
        if (pictureMuseum == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.pictureMuseumService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<PictureMuseum>> getAllE() {
        List<PictureMuseum> pictureMuseums = this.pictureMuseumService.getAll();
        if (pictureMuseums.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pictureMuseums, HttpStatus.OK);
    }
}
