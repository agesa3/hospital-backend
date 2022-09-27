package com.agesadev.healthIt.repository;

import com.agesadev.healthIt.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<String, Patient> {
}
