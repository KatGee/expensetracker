package com.kat.expencetracker.service;

import com.kat.expencetracker.model.Expence;

import java.util.List;

public interface ExpenceService {

    Expence addExpence(Expence expence);
    void deleteExpence(Long id);
    List<Expence> getAllExpences();
    Expence getExpence(Long id);

}
