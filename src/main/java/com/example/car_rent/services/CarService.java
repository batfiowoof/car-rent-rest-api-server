package com.example.car_rent.services;

import com.example.car_rent.entities.Car;
import com.example.car_rent.entities.Client;
import com.example.car_rent.enums.City;
import com.example.car_rent.repositories.CarRepository;
import com.example.car_rent.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final ClientRepository clientRepository;

    private final List<City> validCities = Arrays.asList(City.values());

    @Autowired
    public CarService(CarRepository carRepository, ClientRepository clientRepository) {
        this.carRepository = carRepository;
        this.clientRepository = clientRepository;
    }

    // Method to get all cars by location
    public List<Car> getCarsByClientLocation(int clientId){
        Client client = (Client) this.clientRepository.findById(clientId);

        if (client != null) {
            return this.carRepository.findByLocation(this.clientRepository.findLocationById(clientId));
        } else {
            throw new IllegalArgumentException("Client not found");
        }
    }

    public Car getCarById(int id) {
        return this.carRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Car not found"));
    }

    public List<Car> getAllCars() {
        return this.carRepository.findAll();
    }

    public void createCar(Car car) {
        if(!validateCity(car)) {
            throw new IllegalArgumentException("Invalid city");
        }
        this.carRepository.save(car);
    }

    public void deleteCar(int id) {
        this.carRepository.deleteById(id);
    }

    public void updateCar(Car car) {
        if(!validateCity(car)) {
            throw new IllegalArgumentException("Invalid city");
        }
        this.carRepository.save(car);
    }

    private boolean validateCity(Car car) {
        return validCities.contains(car.getLocation());
    }
}
