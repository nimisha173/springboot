package com.example.EcommerceCar.Controller;

import com.example.EcommerceCar.Model.Car;
import com.example.EcommerceCar.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;
    @PostMapping
    public Car addcar(@RequestBody Car car){
        return carService.addCar(car);
    }
    @GetMapping("/get")
    public List<Car> getcar(){
        return carService.getCar();
    }
}
