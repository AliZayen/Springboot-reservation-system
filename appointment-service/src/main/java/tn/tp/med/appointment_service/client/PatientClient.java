package tn.tp.med.appointment_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.tp.med.appointment_service.dto.PatientDTO;

@FeignClient(name = "patient-service", url = "http://localhost:8090")
public interface PatientClient {
    @GetMapping("/api/patients/{id}")
    PatientDTO getPatient(@PathVariable Long id);
}

