package tn.tp.med.appointment_service.dto;


import lombok.Data;

@Data
public class BookAppointmentRequest {
    private Long availabilityId;
    private Long patientId;
    private Long doctorId;
}
