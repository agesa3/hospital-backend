package com.agesadev.healthIt.services;

import com.agesadev.healthIt.model.Patient;

import java.util.List;

public interface PatientService {

    Patient savePatient(Patient patient);

    List<Patient> getAllPatients();

    Patient getPatientById(String patientIdentifier);

    Patient updatePatient(Patient patient, String patientIdentifier);

    void deletePatient(String patientIdentifier);
}
