package restW.rest;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import restW.model.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import restW.service.PictureService;

import javax.validation.Valid;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/picture")

public class PictureRest {

    @Autowired
    private PictureService pictureService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Picture> getPicture(@PathVariable("id") Integer pictureId) {
        if (pictureId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Picture picture = this.pictureService.getById(pictureId);
        if (picture == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(picture, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Picture> save(@RequestBody @Valid Picture picture) {
        HttpHeaders headers = new HttpHeaders();
        if (picture == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.pictureService.save(picture);
        return new ResponseEntity<>(picture, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Picture> update(@RequestBody @Valid Picture picture, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();
        if (picture == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.pictureService.save(picture);
        return new ResponseEntity<>(picture, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Picture> deleteE(@PathVariable("id") Integer id) {
        Picture picture = this.pictureService.getById(id);
        if (picture == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.pictureService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Picture>> getAllE() {
        List<Picture> pictures = this.pictureService.getAll();
        if (pictures.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pictures, HttpStatus.OK);
    }
}
