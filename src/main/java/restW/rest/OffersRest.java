package restW.rest;

import org.springframework.web.servlet.ModelAndView;
import restW.model.Offers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import restW.service.OffersService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/offers")

public class OffersRest {

    @Autowired
    private OffersService offersService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Offers> getOffers(@PathVariable("id") Integer offersId) {
        if (offersId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Offers offers = this.offersService.getById(offersId);
        if (offers == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(offers, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Offers> save(@RequestBody @Valid Offers offers) {
        HttpHeaders headers = new HttpHeaders();
        if (offers == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.offersService.save(offers);
        return new ResponseEntity<>(offers, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Offers> update(@RequestBody @Valid Offers offers, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();
        if (offers == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.offersService.save(offers);
        return new ResponseEntity<>(offers, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Offers> deleteE(@PathVariable("id") Integer id) {
        Offers offers = this.offersService.getById(id);
        if (offers == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.offersService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Offers>> getAllE() {
        List<Offers> offers = this.offersService.getAll();
        if (offers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(offers, HttpStatus.OK);
    }
}
