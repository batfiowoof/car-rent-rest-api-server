package com.example.car_rent.controllers;

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
        try {
            this.offerService.createOffer(offer);
            return ResponseEntity.ok(offer);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid offer");
        }
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<List<Offer>> getAllOffersByClientId(@PathVariable int clientId) {
        try {
            List<Offer> offers = this.offerService.getAllOffersByClientId(clientId);
            return ResponseEntity.ok(offers);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid client ID");
        }
    }

    @GetMapping("/offer/{id}")
    public ResponseEntity<Offer> getOfferById(@PathVariable int id) {
        try {
            Offer offer = this.offerService.getOfferById(id);
            return ResponseEntity.ok(offer);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid offer ID");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOffer(@PathVariable int id) {
        try {
            this.offerService.deleteOffer(id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid offer ID");
        }
    }

    @PutMapping("/accept/{id}")
    public ResponseEntity<Void> acceptOffer(@PathVariable int id) {
        try {
            this.offerService.acceptOffer(id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid offer ID");
        }
    }
}
