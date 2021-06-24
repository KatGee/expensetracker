package com.kat.expencetracker.service;

import com.kat.expencetracker.model.User;
import com.kat.expencetracker.model.UserRegistration;

public interface UserService {

    User findByUserName(String username);
    User save(UserRegistration userRegistration);
}
