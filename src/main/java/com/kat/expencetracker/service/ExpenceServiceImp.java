package com.kat.expencetracker.service;


import com.kat.expencetracker.model.Expence;
import com.kat.expencetracker.model.User;
import com.kat.expencetracker.repository.ExpenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenceServiceImp implements ExpenceService{

    @Autowired
    ExpenceRepository expenceRepository;

    @Override
    public Expence addExpence(Expence expence) {

        if(expence.getCreatedAt() == null)
        {
            expence.setCreatedAt(LocalDate.now());
            expence.setModifiedAt(LocalDate.now());
        }else{
            expence.setModifiedAt(LocalDate.now());
        }
        return expenceRepository.save(expence);
    }

    @Override
    public void deleteExpence(Long id) {
        Expence expence = getExpence(id);
        expenceRepository.delete(expence);
    }

    @Override
    public List<Expence> getAllExpences(User user) {
        return expenceRepository.findByUser(user);
    }

    @Override
    public Expence getExpence(Long id) {
        return expenceRepository.findById(id).get();
    }

}
