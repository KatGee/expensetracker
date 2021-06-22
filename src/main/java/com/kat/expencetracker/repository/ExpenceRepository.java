package com.kat.expencetracker.repository;

import com.kat.expencetracker.model.Expence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenceRepository extends JpaRepository<Expence, Long> {
}
