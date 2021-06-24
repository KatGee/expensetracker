package com.kat.expencetracker.service;

import com.kat.expencetracker.model.MyUserDetails;
import com.kat.expencetracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String usersname) throws UsernameNotFoundException {
        User user = userService.findByUserName(usersname);
        MyUserDetails myUserDetails = new MyUserDetails(user);
        return myUserDetails;
    }
}
