package com.kat.expencetracker.service;


import com.kat.expencetracker.model.Expence;
import com.kat.expencetracker.repository.ExpenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenceServiceImp implements ExpenceService{

    @Autowired
    ExpenceRepository expenceRepository;

    @Override
    public Expence addExpence(Expence expence) {
        return null;
    }

    @Override
    public void deleteExpence(Long id) {

    }

    @Override
    public List<Expence> getAllExpences() {
        return null;
    }

    @Override
    public Expence getExpence(Long id) {
        return null;
    }

}
