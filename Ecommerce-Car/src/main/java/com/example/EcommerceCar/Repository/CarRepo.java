package com.example.EcommerceCar.Repository;


import com.example.EcommerceCar.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepo extends JpaRepository<Car,Integer> {
}
