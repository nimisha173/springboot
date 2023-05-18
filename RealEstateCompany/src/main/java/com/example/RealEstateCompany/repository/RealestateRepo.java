package com.example.RealEstateCompany.repository;

import com.example.RealEstateCompany.entity.Realestate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RealestateRepo extends JpaRepository<Realestate,Integer> {
    List<Realestate> findByZipcode(double zipCode);


    List<Realestate> findByState(String state);

    List<Realestate> findByCity(String city);

    List<Realestate> findByBed(double bed);
}
