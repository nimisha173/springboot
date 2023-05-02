package com.example.Employee.controller;

import com.example.Employee.entity.Employee;
import com.example.Employee.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmpController {
    @Autowired
    public EmpService empservice;
    @PostMapping("/post")
    public Employee addDetails(@RequestBody Employee emp){
        return empservice.addEmp(emp);
    }
    @GetMapping("/g")
    public List<Employee> getDetails(){
        return empservice.getAllDetails();
    }
    @GetMapping("/{Id}")
    public Employee getById(@PathVariable Integer Id){
        return empservice.getId(Id);
    }
    @GetMapping("/I/{name}")
    public Employee GetByName(@PathVariable String name){
        return empservice.GetByName1(name);
    }
    @PutMapping("/p")
    public Employee putBtId(@RequestBody Employee emp){
        return empservice.PutId(emp);
    }
    @DeleteMapping("/d/{Id}")
    public String Delete(@PathVariable Integer Id){
        return empservice.DeleteId(Id);
    }
}
