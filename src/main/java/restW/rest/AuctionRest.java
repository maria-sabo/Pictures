package restW.rest;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import restW.model.Auction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import restW.service.AuctionService;

import javax.validation.Valid;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/auction")

public class AuctionRest {

    @Autowired
    private AuctionService auctionService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Auction> getAuction(@PathVariable("id") Integer auctionId) {
        if (auctionId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Auction auction = this.auctionService.getById(auctionId);
        if (auction == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(auction, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Auction> save(@RequestBody @Valid Auction auction) {
        HttpHeaders headers = new HttpHeaders();
        if (auction == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.auctionService.save(auction);
        return new ResponseEntity<>(auction, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Auction> update(@RequestBody @Valid Auction auction, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();
        if (auction == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.auctionService.save(auction);
        return new ResponseEntity<>(auction, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Auction> deleteE(@PathVariable("id") Integer id) {
        Auction auction = this.auctionService.getById(id);
        if (auction == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.auctionService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Auction>> getAllE() {
        List<Auction> auctions = this.auctionService.getAll();
        if (auctions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(auctions, HttpStatus.OK);
    }
}
