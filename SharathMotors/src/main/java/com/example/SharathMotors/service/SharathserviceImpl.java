package com.example.SharathMotors.service;

import com.example.SharathMotors.model.Car;
import com.example.SharathMotors.repository.Sharathrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SharathserviceImpl implements Sharathservice{
    @Autowired
    public Sharathrepo sharathrepo;
    @Override
    public Car addCar(Car car) {
        return sharathrepo.save(car);
    }


    public List<Car> getAllCar() {
        return sharathrepo.findAll();
    }

    public Car getCarByDate(String date) {
        return sharathrepo.findByDate(date);
    }
}
