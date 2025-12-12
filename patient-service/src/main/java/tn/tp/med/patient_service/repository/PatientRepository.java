package tn.tp.med.patient_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.tp.med.patient_service.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> { }

