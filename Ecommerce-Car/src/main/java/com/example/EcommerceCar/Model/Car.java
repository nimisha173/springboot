package com.example.EcommerceCar.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer year;
    @ElementCollection
    private List<String> color;
    @ElementCollection
    private List<String>accessories;
    private long price;
    @ElementCollection
    private List<String>paymenttype;
    @ElementCollection
    private List<String>city;
}
