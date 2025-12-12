package tn.tp.med.appointment_service.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tn.tp.med.appointment_service.model.Appointment;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByPatientId(Long patientId);
    List<Appointment> findByDoctorId(Long doctorId);
    List<Appointment> findByAvailabilityId(Long availabilityId);

}