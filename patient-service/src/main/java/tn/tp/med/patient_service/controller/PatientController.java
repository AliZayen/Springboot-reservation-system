package tn.tp.med.patient_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.tp.med.patient_service.model.Patient;
import tn.tp.med.patient_service.repository.PatientRepository;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientRepository repository;

    @GetMapping
    public List<Patient> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public Patient create(@RequestBody Patient p) {
        return repository.save(p);
    }

    @GetMapping("/{id}")
    public Patient findById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }
}
