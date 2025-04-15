package com.example.car_rent.services;

import com.example.car_rent.dto.OfferDTO;
import com.example.car_rent.entities.Car;
import com.example.car_rent.entities.Offer;
import com.example.car_rent.enums.CarErrorType;
import com.example.car_rent.enums.OfferErrorType;
import com.example.car_rent.exceptions.CarException;
import com.example.car_rent.exceptions.OfferException;
import com.example.car_rent.repositories.CarRepository;
import com.example.car_rent.repositories.ClientRepository;
import com.example.car_rent.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
            throw new OfferException(OfferErrorType.INVALID_DATA);
        }
        double price = calculatePrice(offer);
        offer.setPrice(price);
        this.offerRepository.save(offer);
    }

    public List<Offer> getAllOffersByClientId(int clientId) {
         return this.offerRepository.findAllByClientId(clientId);
    }

    //replaced by dto
//    public Offer getOfferById(int id) {
//        return this.offerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Offer not found"));
//    }

    public void deleteOffer(int id) {
        this.offerRepository.delete(id);
    }

    public void acceptOffer(int id) {
        this.offerRepository.acceptOffer(id);
    }

    private boolean validateOffer(Offer offer) {
        return this.clientRepository.existsById(offer.getClient().getId()) && this.carRepository.existsById(offer.getCar().getId());
    }


    //if contains weekend, then 10% more for the weekdays
    private double calculatePrice(Offer offer) {
        Car car = this.carRepository.findById(offer.getCar().getId()).orElseThrow(() -> new CarException(CarErrorType.NOT_FOUND));

        double basePrice = car.getDailyPrice();
        double totalPrice = 0;

        LocalDate startDate = offer.getStartDate();
        LocalDate endDate = offer.getEndDate();

        if (endDate.isBefore(startDate)) {
            throw new OfferException(OfferErrorType.INVALID_DATE);
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

    public OfferDTO getOfferDTOById(int id) {
        Offer offer = this.offerRepository.findById(id).orElseThrow(() -> new OfferException(OfferErrorType.NOT_FOUND));

        double totalPrice = calculatePrice(offer);
        return OfferDTO.builder()
                .id(offer.getId())
                .clientName(offer.getClient().getName())
                .carBrand(offer.getCar().getBrand())
                .carModel(offer.getCar().getModel())
                .dailyPrice(offer.getCar().getDailyPrice())
                .location(offer.getCar().getLocation().toString())
                .days((int) ChronoUnit.DAYS.between(offer.getStartDate(), offer.getEndDate()))
                .totalPrice(totalPrice)
                .build();
    }
}
