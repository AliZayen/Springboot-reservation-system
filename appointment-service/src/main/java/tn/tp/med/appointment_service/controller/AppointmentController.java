package tn.tp.med.appointment_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.tp.med.appointment_service.dto.BookAppointmentRequest;
import tn.tp.med.appointment_service.model.Appointment;
import tn.tp.med.appointment_service.repository.AppointmentRepository;
import tn.tp.med.appointment_service.service.AppointmentService;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final AppointmentRepository appointmentRepository;

    @GetMapping
    public List<Appointment> getAllDoctors() {
        return appointmentRepository.findAll();
    }

    @PostMapping("/book")
    public Appointment book(@RequestBody BookAppointmentRequest request) {
        return appointmentService.book(
                request.getAvailabilityId(),
                request.getPatientId()
        );
    }

    @GetMapping("/patient/{id}")
    public List<Appointment> getPatientAppointments(@PathVariable Long id) {
        return appointmentService.getAppointmentsForPatient(id);
    }

    @GetMapping("/doctor/{id}")
    public List<Appointment> getDoctorAppointments(@PathVariable Long id) {
        return appointmentService.getAppointmentsForDoctor(id);
    }
}
