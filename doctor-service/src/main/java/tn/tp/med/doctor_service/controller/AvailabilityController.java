package tn.tp.med.doctor_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.tp.med.doctor_service.model.Availability;
import tn.tp.med.doctor_service.model.Doctor;
import tn.tp.med.doctor_service.repository.AvailabilityRepository;

import java.util.List;

@RestController
@RequestMapping("/api/availabilities")
@RequiredArgsConstructor
public class AvailabilityController {

    private final AvailabilityRepository repository;

    @GetMapping
    public List<Availability> findAll() { return repository.findAll(); }

    @GetMapping("/doctor/{doctorId}")
    public List<Availability> getByDoctor(@PathVariable Long doctorId) {
        return repository.findByDoctorId(doctorId);
    }

    @GetMapping("/{id}")
    public Availability getById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Availability not found"));
    }


    @PostMapping("/doctor/{doctorId}")
    public Availability create(
            @PathVariable Long doctorId,
            @RequestBody Availability availability
    ) {
        availability.setDoctorId(doctorId);
        return repository.save(availability);
    }
}

