package com.example.ExamModel.controller;

import com.example.ExamModel.ExceptionHandler.EmployeeNotFound;
import com.example.ExamModel.dto.ManagerDto;
import com.example.ExamModel.entity.Employee;
import com.example.ExamModel.entity.Manager;
import com.example.ExamModel.repository.EmpRepo;
import com.example.ExamModel.repository.MgRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/office")
public class EmpController {
    @Autowired
    private EmpRepo empRepo;
    @Autowired
    private MgRepo repo;

    @PostMapping("/postemp")
    public ResponseEntity<Employee> postemp(@RequestBody Employee employee) {
        empRepo.save(employee);
        return ResponseEntity.ok().body(employee);
    }
    @GetMapping("all")
    public ResponseEntity<List<Employee>>all(){
        List<Employee>li=empRepo.findAll();
        return ResponseEntity.ok().body(li);
    }
    @GetMapping("/getemp/{eid}")
    public ResponseEntity<Employee> getEmpById(@PathVariable Integer eid) throws EmployeeNotFound {
        Optional<Employee> op1 = empRepo.findById(eid);
        if (op1.isPresent()) {
            return ResponseEntity.ok().body(op1.get());
        } else {
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
             throw new EmployeeNotFound("employee not found");
        }
    }

    @GetMapping("/getempbyName/{name}")
    public ResponseEntity<Employee> getByName(@PathVariable String name) {
        Optional<Employee> op2 = empRepo.findByName(name);
        if (op2.isPresent()) {
            return ResponseEntity.ok().body(op2.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("updateEmp/{eid}")
    public ResponseEntity<Employee> updateemp(@RequestBody Employee employee, @PathVariable Integer eid) {
        Optional<Employee> op3 = empRepo.findById(eid);
        Employee emp;
        if (op3.isPresent()) {
            emp = op3.get();
            emp.setEid(employee.getEid());
            emp.setName(employee.getName());
            emp.setAge(employee.getAge());
            empRepo.save(emp);
            return ResponseEntity.ok().body(emp);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/updateempbyName/{name}")
    public ResponseEntity<Employee> updateByName(@RequestBody Employee employee) {
        Optional<Employee> op4 = empRepo.findByName(employee.getName());
        Employee employee1;
        if (op4.isPresent()) {
            employee1 = op4.get();
            employee1.setEid(employee.getEid());
            employee1.setName(employee.getName());
            employee1.setAge(employee.getAge());
            empRepo.save(employee1);
            return ResponseEntity.ok().body(employee1);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/deleteemp/{eid}")
    public ResponseEntity<String> deleteByid(@PathVariable Integer eid) {
        Optional<Employee> op5 = empRepo.findById(eid);
        if (op5.isPresent()) {
            empRepo.deleteById(eid);
            return ResponseEntity.ok().body("entity deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @PostMapping("/postmanager")
    public ResponseEntity<Manager>post(@RequestBody @Valid ManagerDto managerDto){
        Manager manager=new Manager(0, managerDto.getName());
        repo.save(manager);
        return ResponseEntity.ok().body(manager);
    }
}


