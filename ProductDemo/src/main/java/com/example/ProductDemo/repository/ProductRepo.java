package com.example.ProductDemo.repository;

import com.example.ProductDemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {

    Product findByPname(String name);
}
