package com.example.CurdWithDto.controller;

import com.example.CurdWithDto.Exception.UserNotFountException;
import com.example.CurdWithDto.dto.UserReq;
import com.example.CurdWithDto.entity.User;
import com.example.CurdWithDto.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/USER")
public class UserController {
    @Autowired
    private UserRepo repo;
    @PostMapping("/postuser")
    public ResponseEntity<User>post(@RequestBody @Valid UserReq userReq){
        User user=new User(0, userReq.getName(), userReq.getPno(), userReq.getAge(), userReq.getEmail());
         repo.save(user);
         return ResponseEntity.ok().body(user);
    }
    @GetMapping("/getall")
    public ResponseEntity<List<User>>getall(){
        List<User>userlist=repo.findAll();
        return ResponseEntity.ok().body(userlist);
    }
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<User>getById(@PathVariable Integer id)throws UserNotFountException{
        Optional<User>op1=repo.findById(id);
        if(op1.isPresent()){
           repo.findAll();
            return ResponseEntity.ok().body(op1.get());
        }else{
           // return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            Optional<User> op4 = repo.findById(id);
            if (op4.isPresent()) {
                return ResponseEntity.ok().body(op4.get());
            } else {
                throw new UserNotFountException("user is not found");
            }
        }
    }
    @GetMapping("/getbyname/{name}")
    public ResponseEntity<User>getbyname(@PathVariable String name){
        Optional<User>op2=repo.findByName(name);
        if(op2.isPresent()){
            repo.findByName(name);
            return ResponseEntity.ok().body(op2.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(@RequestBody UserReq userReq ,@PathVariable int id){
       // User user=new User(0, userReq.getName(), userReq.getPno(), userReq.getAge(), userReq.getEmail());
        Optional<User>op3=repo.findById(id);
        if (op3.isPresent()){
            User user1;
            user1=op3.get();
            user1.setId(id);
            user1.setName(userReq.getName());
            user1.setPno(userReq.getPno());
            user1.setAge(userReq.getAge());
            user1.setEmail(userReq.getEmail());
            repo.save(user1);
            return ResponseEntity.ok().body(user1);

        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }


    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>deleteu(@PathVariable Integer id){
        Optional<User>op4=repo.findById(id);
        if(op4.isPresent()){
            repo.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("delete");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


}
