package com.example.Employee.service;

import com.example.Employee.entity.Employee;
import com.example.Employee.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired
    public EmpRepo empRepo;
    public Employee addEmp(Employee emp) {
        return empRepo.save(emp);
    }

    public List<Employee> getAllDetails() {
        return empRepo.findAll();

    }

    public Employee getId(Integer Id) {
        return empRepo.findById(Id).orElse(null);
    }

    public Employee PutId(Employee emp) {
        Employee employee=null;
        Optional<Employee> optionalEmployee=empRepo.findById(emp.getId());
        if(optionalEmployee.isPresent()) {
            employee = optionalEmployee.get();
            employee.setName(emp.getName());
            employee.setRole(emp.getRole());
            employee.setExperience(emp.getExperience());
            empRepo.save(employee);
        }else{
            return new Employee();
        }
        return employee;
    }

    public String DeleteId(Integer Id) {
        empRepo.deleteById(Id);
        return "deleted";
    }

    public Employee GetByName1(String name) {
        return empRepo.findByName(name);
    }
}
