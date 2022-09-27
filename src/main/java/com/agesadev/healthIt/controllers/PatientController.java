package com.agesadev.healthIt.controllers;

import com.agesadev.healthIt.model.Patient;
import com.agesadev.healthIt.services.PatientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PatientController {

    private final PatientServiceImpl patientService;

    //save new patient
    @PostMapping("/save")
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) {
        return new ResponseEntity<>(patientService.savePatient(patient), HttpStatus.CREATED);
    }

    @GetMapping("/{patientIdentifier}")
    public Patient getPatient(@PathVariable String patientIdentifier) {
        return patientService.getPatientById(patientIdentifier);
    }

    @GetMapping("/all")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @PutMapping("/update/{patientIdentifier}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient, @PathVariable String patientIdentifier) {
        return new ResponseEntity<>(patientService.updatePatient(patient, patientIdentifier), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{patientIdentifier}")
    public ResponseEntity<?> deletePatient(@PathVariable String patientIdentifier) {
        patientService.deletePatient(patientIdentifier);
        return ResponseEntity.ok("Patient with id " + patientIdentifier + " deleted successfully");
    }

    @PostMapping("/search")
    public Patient searchPatient(@RequestBody String identifier) {
        return patientService.getPatientById(identifier);
    }
}
