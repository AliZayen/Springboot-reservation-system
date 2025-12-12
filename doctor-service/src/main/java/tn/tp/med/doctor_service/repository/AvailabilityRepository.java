package tn.tp.med.doctor_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.tp.med.doctor_service.model.Availability;
import java.util.List;

public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
    List<Availability> findByDoctorId(Long doctorId);

}