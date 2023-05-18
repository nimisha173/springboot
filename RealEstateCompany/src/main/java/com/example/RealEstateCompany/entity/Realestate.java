package com.example.RealEstateCompany.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "realestate")
public class Realestate {
    @Id
    @GeneratedValue
    private Integer id;
    private String status;
    private double bed;
    private double bath;
    private double acre_lot;
    private String city;
    private String state;
    @Column(name = "zip_code")
    private double zipcode;
    private String house_size;
    private String prev_sold_date;
    private double price;


}
