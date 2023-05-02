package com.example.SharathMotors.repository;

import com.example.SharathMotors.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Sharathrepo extends JpaRepository<Car,Integer> {
    Car findByDate(String date);
}
