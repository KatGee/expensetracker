package com.kat.expencetracker.service;

import com.kat.expencetracker.model.Expence;
import com.kat.expencetracker.model.User;

import java.util.List;

public interface ExpenceService {

    Expence addExpence(Expence expence);
    void deleteExpence(Long id);
    List<Expence> getAllExpences(User user);
    Expence getExpence(Long id);

}
