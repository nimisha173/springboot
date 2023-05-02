package com.example.ProductDemo.service;

import com.example.ProductDemo.model.Product;
import com.example.ProductDemo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProService {
    @Autowired
    public ProductRepo repo;
    public Product propost(Product pro) {

        return repo.save(pro);
    }

    public List<Product> getproall() {
        return repo.findAll();
    }

    public Product getproById(Integer id) {

        return repo.findById(id).orElse(null);
    }

    public Product putpro(Product pro) {
        Product product=null;
        Optional<Product>optionaldata=repo.findById(pro.getId());
        if(optionaldata.isPresent()){
            product=optionaldata.get();
            product.setPname(product.getPname());
            product.setPprice(product.getPprice());
            product.setPcategory(product.getPcategory());
            repo.save(product);
        }else {
            return new Product();
        }
        return product;
    }

    public String DeleteId(Integer Id) {
        repo.deleteById(Id);
        return "deleted";
    }

    public Product getproByPname(String pname) {
        return repo.findByPname(pname);
    }
}
