package com.example.RealEstateCompany.controller;

import com.example.RealEstateCompany.entity.Realestate;
import com.example.RealEstateCompany.service.RealestateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/real")
public class RealestateController {
    @Autowired
    private RealestateService realestateService;
    @GetMapping("/info")
    public List<Realestate> getAll(){
        return realestateService.getreal();
    }
    @GetMapping("/ZIP/{zipcode}")
    public List<Realestate> gethouse(@PathVariable double zipcode){
        return realestateService.getHouseStatus(zipcode);
    }
    @GetMapping("/{state}")
    public List<Realestate>getState(@PathVariable String state){
        return realestateService.getBystate(state);
    }
    @GetMapping("city/{city}")
    public List<Realestate>getcity(@PathVariable String city){
        return realestateService.getcity(city);
    }
    @GetMapping("p/{price}")
    public List<Realestate>getprice(@PathVariable double price){
        return realestateService.getprice(price);
    }
    @GetMapping("/bath")
    public List<Realestate>getbath(){
        return realestateService.getbath((double) 2);
    }
    @GetMapping("/bed")
    public List<Realestate>getbed(){

        return realestateService.getbed((double) 2);
    }
    @GetMapping("status/{status}")
    public int getstatus(String city){
        return realestateService.getStatus(city);
    }
}
