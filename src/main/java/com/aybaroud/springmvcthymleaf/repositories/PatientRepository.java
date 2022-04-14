package com.aybaroud.springmvcthymleaf.repositories;

import com.aybaroud.springmvcthymleaf.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository
        extends JpaRepository<Patient,Long> {
}
