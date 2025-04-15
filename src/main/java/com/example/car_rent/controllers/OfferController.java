package com.example.car_rent.controllers;

import com.example.car_rent.dto.OfferDTO;
import com.example.car_rent.entities.Offer;
import com.example.car_rent.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offers")
public class OfferController {

    private final OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @PostMapping
    public ResponseEntity<Offer> createOffer(@RequestBody Offer offer) {
        offerService.createOffer(offer);
        return ResponseEntity.ok(offer);
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<Offer>> getAllOffersByClientId(@PathVariable int clientId) {
        List<Offer> offers = offerService.getAllOffersByClientId(clientId);
        return ResponseEntity.ok(offers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfferDTO> getOfferById(@PathVariable int id) {
        OfferDTO offer = offerService.getOfferDTOById(id);
        return ResponseEntity.ok(offer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffer(@PathVariable int id) {
        offerService.deleteOffer(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/accept/{id}")
    public ResponseEntity<Void> acceptOffer(@PathVariable int id) {
        offerService.acceptOffer(id);
        return ResponseEntity.ok().build();
    }
}
