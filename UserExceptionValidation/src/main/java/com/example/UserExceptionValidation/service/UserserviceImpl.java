package com.example.UserExceptionValidation.service;

import com.example.UserExceptionValidation.Entity.User;
import com.example.UserExceptionValidation.Exception.UserNotFoundException;
import com.example.UserExceptionValidation.dto.UserRequest;
import com.example.UserExceptionValidation.repository.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface UserserviceImpl implements Userservice{
    @Autowired
    private Userrepo userrepo;
    @Override
    public User PostUser(UserRequest userRequest) {
        User user=User.build(0, userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(), userRequest.getAge());
        return userrepo.save(user);
    }
    @Override
    public List<User> getuser() {
        return userrepo.findAll();
    }
    @Override
    public Optional<User> GetById(Integer id) throws UserNotFoundException {
        Optional<User> user=userrepo.findById(id);
        if(user!=null){
            return user;
        }else{
            throw new UserNotFoundException("user not found with id:"+id);
        }
    }




}
