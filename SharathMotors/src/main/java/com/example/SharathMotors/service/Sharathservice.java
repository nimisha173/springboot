package com.example.SharathMotors.service;

import com.example.SharathMotors.model.Car;

import java.util.List;

public interface Sharathservice {
    Car addCar(Car car);
    List<Car> getAllCar();
    Car getCarByDate(String date);

}