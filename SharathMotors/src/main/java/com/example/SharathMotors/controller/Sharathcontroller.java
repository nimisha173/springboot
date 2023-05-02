package com.example.SharathMotors.controller;

import com.example.SharathMotors.model.Car;
import com.example.SharathMotors.service.SharathserviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sharathcars/car")
public class Sharathcontroller {
    @Autowired
    private SharathserviceImpl sharathservice;
    @PostMapping("/post")
    public Car addCar(@RequestBody Car car){
        return sharathservice.addCar(car) ;
    }
    @GetMapping("/getall")
    public List<Car> getAllcar() {
        return sharathservice.getAllCar();
    }
    @GetMapping("/getall/{date}")
    public Car getdate(@PathVariable ("date")String date){
        return sharathservice.getCarByDate(date);
    }
}
