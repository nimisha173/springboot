package com.example.RealEstateCompany.service;

import com.example.RealEstateCompany.entity.Realestate;
import com.example.RealEstateCompany.repository.RealestateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RealestateService {
    @Autowired
    private RealestateRepo realestateRepo;


    public List<Realestate> getHouseStatus(double zipCode) {

        return realestateRepo.findByZipcode(zipCode);
    }


    public List<Realestate> getreal() {
        return realestateRepo.findAll();
    }

    public List<Realestate> getBystate(String state) {

        return realestateRepo.findByState(state);
    }

    public List<Realestate> getcity(String city) {

        return realestateRepo.findByCity(city);
    }


    public List<Realestate> getprice(double price) {
        return realestateRepo.findAll().stream().filter(p->p.getPrice()<price)
                .collect(Collectors.toList());
    }

    public List<Realestate> getbath(double bath) {
        return realestateRepo.findAll().stream().filter(k->k.getBath()==2)
                .collect(Collectors.toList());
    }

    public List<Realestate> getbed(double bed) {
        return realestateRepo.findByBed(bed);
    }

    public int getStatus(String city) {
        return (int) realestateRepo.findAll().stream().filter(m->m.getCity().equals(city)).
                filter(j->j.getStatus().equals("not_sale")).count();
    }
}
