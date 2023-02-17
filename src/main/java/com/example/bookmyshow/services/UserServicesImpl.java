package com.example.bookmyshow.services;

import com.example.bookmyshow.models.User;
import com.example.bookmyshow.repository.UserRepository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServicesImpl implements UserServices{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        Optional<User> userObj = this.userRepository.findById(user.getUserId());    
        if(userObj.isPresent()){
            User updatedUser = userObj.get();
            updatedUser.setName(user.getName());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setContactNumber(user.getContactNumber());
            return this.userRepository.save(updatedUser);
        } else {
            throw new RuntimeException("User not found with id: " + user.getUserId());
        }
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> userObj = this.userRepository.findById(id);
        if(userObj.isPresent()){
            return userObj.get();
        } else {
            throw new RuntimeException("User not found with id " + id);
        }
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> userObj = this.userRepository.findById(id);
        if(userObj.isPresent()){
            this.userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User not found with id " + id);
        }
    }
}
