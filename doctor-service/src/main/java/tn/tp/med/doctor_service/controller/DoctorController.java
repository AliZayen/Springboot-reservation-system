package tn.tp.med.doctor_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.tp.med.doctor_service.model.Doctor;
import tn.tp.med.doctor_service.repository.DoctorRepository;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorRepository repository;

    @GetMapping
    public List<Doctor> findAll() { return repository.findAll(); }

    @PostMapping
    public Doctor create(@RequestBody Doctor doctor) {
        return repository.save(doctor);
    }

    @GetMapping("/{id}")
    public Doctor findById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
    }


}

//hhhhh