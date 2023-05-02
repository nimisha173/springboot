package com.example.SharathMotors.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue
    public Integer cid;
    public String cname;
    public String price;
    public String brand;
    public String color;
    public Integer noofseats;
    public String date;
}
