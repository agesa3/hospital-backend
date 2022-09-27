package com.agesadev.healthIt.services;

import com.agesadev.healthIt.model.Patient;
import com.agesadev.healthIt.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public Patient savePatient(Patient patient) {
        String identifier = generateIdentifier(patient);
        patient.setPatientIdentifier(identifier);
        return patientRepository.save(patient);
    }

    private String generateIdentifier(Patient patient) {
        String randomNumbers = String.valueOf((int) (Math.random() * 1000));
        String patientBirthCertNumber = patient.getBirthCertificate();
        return randomNumbers + patientBirthCertNumber;
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(String patientIdentifier) {
        return patientRepository.findById(patientIdentifier)
                .orElseThrow(() -> new RuntimeException("Patient with id " + patientIdentifier + " does not exist"));
    }

    @Override
    public Patient updatePatient(Patient patient, String patientIdentifier) {
        Patient patient1 = patientRepository.findById(patientIdentifier).get();
        patient1.setFirstName(patient.getFirstName());
        patient1.setLastName(patient.getLastName());
        patient1.setGender(patient.getGender());
        patient1.setDateOfBirth(patient.getDateOfBirth());
        patient1.setLocation(patient.getLocation());
        patient1.setPhoneNumber(patient.getPhoneNumber());
        patient1.setBirthCertificate(patient.getBirthCertificate());
        patient1.setIdNumber(patient.getIdNumber());
        return patientRepository.save(patient1);
    }

    @Override
    public void deletePatient(String patientIdentifier) {
        patientRepository.deleteById(patientIdentifier);
    }
}
