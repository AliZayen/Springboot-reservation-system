package tn.tp.med.appointment_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;
import tn.tp.med.appointment_service.client.DoctorClient;
import tn.tp.med.appointment_service.client.PatientClient;
import tn.tp.med.appointment_service.model.Appointment;
import tn.tp.med.appointment_service.dto.AvailabilityDTO;
import tn.tp.med.appointment_service.dto.PatientDTO;
import tn.tp.med.appointment_service.repository.AppointmentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@EnableFeignClients(basePackages = "tn.tp.med.appointment_service.client")
public class AppointmentService {

    private final AppointmentRepository apptRepo;
    private final PatientClient patientClient;
    private final DoctorClient doctorClient;
    private final RabbitTemplate rabbitTemplate;


    public Appointment book(Long availabilityId, Long patientId) {
        PatientDTO patient = patientClient.getPatient(patientId);

        AvailabilityDTO availability = doctorClient.getAvailability(availabilityId);
        List<Appointment> apptAvailable = apptRepo.findByAvailabilityId(availabilityId);

        System.out.println(apptAvailable);
        if (!apptAvailable.isEmpty())
            throw new RuntimeException("Unavailable slot");

        Appointment appt = Appointment.builder()
                .patientId(patientId)
                .availabilityId(availabilityId)
                .doctorId(availability.getDoctorId())
                .build();

        apptRepo.save(appt);

        rabbitTemplate.convertAndSend(
                "appointments.exchange",
                "appointments.created",
                appt);

        return appt;
    }
    public List<Appointment> getAppointmentsForPatient(Long id) {
        return apptRepo.findByPatientId(id);
    }
    public List<Appointment> getAppointmentsForDoctor(Long id) {
        return apptRepo.findByDoctorId(id);
    }

}
