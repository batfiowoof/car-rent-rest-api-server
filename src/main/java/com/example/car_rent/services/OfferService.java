package com.example.car_rent.services;

import com.example.car_rent.entities.Offer;
import com.example.car_rent.repositories.CarRepository;
import com.example.car_rent.repositories.ClientRepository;
import com.example.car_rent.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    private final ClientRepository clientRepository;
    private final OfferRepository offerRepository;
    private final CarRepository carRepository;

    @Autowired
    public OfferService(ClientRepository clientRepository, OfferRepository offerRepository, CarRepository carRepository) {
        this.clientRepository = clientRepository;
        this.offerRepository = offerRepository;
        this.carRepository = carRepository;
    }

    public void createOffer(Offer offer) {
        if (!validateOffer(offer)) {
            throw new IllegalArgumentException("Invalid offer");
        }
        this.offerRepository.save(offer);
    }

    public List<Offer> getAllOffersByClientId(int clientId) {
         return this.offerRepository.findAllByClientId(clientId);
    }

    public Offer getOfferById(int id) {
        return this.offerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Offer not found"));
    }

    public void deleteOffer(int id) {
        this.offerRepository.deleteById(id);
    }

    public void acceptOffer(int id) {
        this.offerRepository.acceptOffer(id);
    }

    private boolean validateOffer(Offer offer) {
        return this.clientRepository.existsById(offer.getClientId()) && this.carRepository.existsById(offer.getCarId());
    }
}
