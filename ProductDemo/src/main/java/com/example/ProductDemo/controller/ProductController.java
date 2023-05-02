package com.example.ProductDemo.controller;

import com.example.ProductDemo.model.Product;
import com.example.ProductDemo.service.ProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pro/")
public class ProductController {
    @Autowired
    public ProService productService;
    @PostMapping("/post")
    public Product propost(@RequestBody Product pro){

        return productService.propost(pro);
    }
    @GetMapping("/all")
    public List<Product> getpro(){
        return productService.getproall();

    }
    @GetMapping("ge/{id}")
    public Product getproById(@PathVariable("id") Integer id){
        return productService.getproById(id);
    }
    @GetMapping("/{pname}")
    public Product getname(@PathVariable String pname){
        return productService.getproByPname(pname);
    }
    @PutMapping("/update/{id}")
    public Product putpro(@RequestBody Product pro){
        return productService.putpro(pro);
    }
    @DeleteMapping("/d/{Id}")
    public String Delete(@PathVariable Integer Id){
        return productService.DeleteId(Id);
    }




}
