package com.kat.expencetracker.repository;

import com.kat.expencetracker.model.Expence;
import com.kat.expencetracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenceRepository extends JpaRepository<Expence, Long> {
    List<Expence> findByUser(User user);
}
