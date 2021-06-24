package com.kat.expencetracker.service;

import com.kat.expencetracker.model.User;
import com.kat.expencetracker.model.UserRegistration;
import com.kat.expencetracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(UserRegistration userRegistration) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(userRegistration.getPassword()).toString();
        User user = new User();
        user.setFirstname(userRegistration.getFirstname());
        user.setLastname(userRegistration.getLastname());
        user.setUsername(userRegistration.getUsername());
        user.setEmail(userRegistration.getEmail());
        user.setPassword(encodedPassword);

        return userRepository.save(user);
    }
}
