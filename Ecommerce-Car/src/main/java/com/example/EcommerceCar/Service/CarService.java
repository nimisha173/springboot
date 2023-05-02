package com.example.EcommerceCar.Service;

import com.example.EcommerceCar.Model.Car;
import com.example.EcommerceCar.Repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarService {
    @Autowired
    private CarRepo carRepo;
    public Car addCar(Car car) {
        return carRepo.save(car);
    }

    public List<Car> getCar() {
        return carRepo.findAll();
    }
}
