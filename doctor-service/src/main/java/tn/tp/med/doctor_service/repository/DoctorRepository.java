package tn.tp.med.doctor_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.tp.med.doctor_service.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> { }
