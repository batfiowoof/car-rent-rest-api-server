package com.example.car_rent.services;

import com.example.car_rent.entities.Car;
import com.example.car_rent.entities.Offer;
import com.example.car_rent.repositories.CarRepository;
import com.example.car_rent.repositories.ClientRepository;
import com.example.car_rent.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
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
        double price = calculatePrice(offer);
        offer.setPrice(price);
        this.offerRepository.save(offer);
    }

    public List<Offer> getAllOffersByClientId(int clientId) {
         return this.offerRepository.findAllByClientId(clientId);
    }

    public Offer getOfferById(int id) {
        return this.offerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Offer not found"));
    }

    public void deleteOffer(int id) {
        this.offerRepository.delete(id);
    }

    public void acceptOffer(int id) {
        this.offerRepository.acceptOffer(id);
    }

    private boolean validateOffer(Offer offer) {
        return this.clientRepository.existsById(offer.getClientId()) && this.carRepository.existsById(offer.getCarId());
    }

    //if contains weekend, then 10% more for the weekdays
    private double calculatePrice(Offer offer) {
        Car car = this.carRepository.findById(offer.getCarId()).orElseThrow(() -> new IllegalArgumentException("Car not found"));

        double basePrice = car.getDailyPrice();
        double totalPrice = 0;

        LocalDate startDate = offer.getStartDate();
        LocalDate endDate = offer.getEndDate();

        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("End date cannot be before start date");
        }

        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            if (currentDate.getDayOfWeek() == DayOfWeek.SATURDAY || currentDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                totalPrice += basePrice * 1.10; // 10% повече за уикенда
            }
            else {
                totalPrice += basePrice;
            }
            currentDate = currentDate.plusDays(1);
        }

        if (offer.isHasAccidents()) {
            totalPrice += 200;
        }

        return totalPrice;
    }
}
