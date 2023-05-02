package com.example.UserExceptionValidation.service;

import com.example.UserExceptionValidation.Entity.User;
import com.example.UserExceptionValidation.Exception.NameFoundException;
import com.example.UserExceptionValidation.Exception.UserNotFoundException;
import com.example.UserExceptionValidation.dto.UserRequest;
import com.example.UserExceptionValidation.repository.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserserviceImpl implements Userservice{
    @Autowired
    private Userrepo userrepo;
    @Override
    public User PostUser(UserRequest userRequest) throws NameFoundException {
        User user= new User(0, userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(), userRequest.getAge());
        Optional<User> namee = userrepo.findByName(user.getName());
        if(namee.isPresent()){
            throw new NameFoundException("name already present");
        }
        else {
            return userrepo.save(user);
        }
    }



    public User PostUser(User user) {
        return null;
    }

    public List<User> getuser() {
        return userrepo.findAll();
    }

    public Optional<User> GetById(Integer id) throws UserNotFoundException {
        Optional<User> user=userrepo.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id not found");
        }
        else{
            return userrepo.findById(id);
        }
    }




}
