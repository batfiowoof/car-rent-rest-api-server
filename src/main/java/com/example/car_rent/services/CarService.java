package com.example.car_rent.services;

import com.example.car_rent.entities.Car;
import com.example.car_rent.entities.Client;
import com.example.car_rent.enums.CarErrorType;
import com.example.car_rent.enums.City;
import com.example.car_rent.exceptions.CarException;
import com.example.car_rent.repositories.CarRepository;
import com.example.car_rent.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
        Optional<Client> client = this.clientRepository.findById(clientId);

        if (client.isPresent()) {
            return this.carRepository.findByLocation(this.clientRepository.findLocationById(clientId));
        }
            throw new IllegalArgumentException("Client not found");
    }

    public Car getCarById(int id) {
        return this.carRepository.findById(id).orElseThrow(() -> new CarException(CarErrorType.NOT_FOUND));
    }

    public List<Car> getAllCars() {
        return this.carRepository.findAll();
    }

    public void createCar(Car car) {
        if (this.carRepository.existsById(car.getId())) {
            throw new CarException(CarErrorType.DUPLICATE_CAR);
        }
        this.carRepository.save(car);
    }

    public void deleteCar(int id) {
        this.carRepository.delete(id);
    }

    public void updateCar(Car car) {
        if(!validateCity(car)) {
            throw new CarException(CarErrorType.INVALID_CITY);
        }
        this.carRepository.save(car);
    }

    private boolean validateCity(Car car) {
        return validCities.contains(car.getLocation());
    }
}
