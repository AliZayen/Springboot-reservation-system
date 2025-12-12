package tn.tp.med.appointment_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.tp.med.appointment_service.dto.AvailabilityDTO;

@FeignClient(name = "doctor-service", url = "http://localhost:8091")
public interface DoctorClient {

    @GetMapping("/api/availabilities/{id}")
    AvailabilityDTO getAvailability(@PathVariable Long id);
}

