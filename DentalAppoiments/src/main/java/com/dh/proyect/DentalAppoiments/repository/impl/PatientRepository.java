package com.dh.proyect.DentalAppoiments.repository.impl;
import com.dh.proyect.DentalAppoiments.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends  JpaRepository<Patient, Long> {
}

