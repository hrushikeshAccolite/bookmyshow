package com.example.bookmyshow.services;

import java.util.List;

import com.example.bookmyshow.models.User;

public interface UserServices {
    User createUser(User user);
    User updateUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    void deleteUser(Long id);
}
