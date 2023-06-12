package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Medication;
import com.example.demo.Entity.User;

public interface MedicationRepo extends JpaRepository<Medication, Integer> {

}
