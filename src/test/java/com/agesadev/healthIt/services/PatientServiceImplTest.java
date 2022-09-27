package com.agesadev.healthIt.services;


import com.agesadev.healthIt.model.Patient;
import com.agesadev.healthIt.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class PatientServiceImplTest {

    @Autowired
    private PatientServiceImpl patientService;

    @MockBean
    private PatientRepository patientRepository;


//    private String patientIdentifier;
//    private String firstName;
//    private String lastName;
//    private String birthCertificate;
//    private String idNumber;
//    private String location;
//    private String phoneNumber;
//    private String dateOfBirth;
//    private String gender;

    @Test
    public void savePatient() {

        //save patient
        Patient patient = new Patient();
        patient.setFirstName("John");
        patient.setLastName("Doe");
        patient.setDateOfBirth("12/12/1990");
        patient.setPatientIdentifier("123456");
        patient.setIdNumber("123456");
        patient.setLocation("Nairobi");
        patient.setBirthCertificate("1232434");

        patientService.savePatient(patient);
        when(patientRepository.save(patient)).thenReturn(patient);
        assertEquals(patient, patientService.savePatient(patient));
    }


    @Test
    public void getAllPatients() {
        Patient patient1 = new Patient();
        Patient patient2 = new Patient();

        when(patientRepository.findAll()).thenReturn(Arrays.asList(patient1, patient2));
        assertEquals(2, patientService.getAllPatients().size());
    }


    @Test
    public void getPatientById() {
        Patient patient = new Patient();
        patient.setFirstName("John");
        patient.setLastName("Doe");
        patient.setDateOfBirth("12/12/1990");
        patient.setPatientIdentifier("123456");
        patient.setIdNumber("123456");
        patient.setLocation("Nairobi");
        patient.setBirthCertificate("1232434");

        when(patientRepository.findById("123456")).thenReturn(java.util.Optional.of(patient));
        assertEquals(patient, patientService.getPatientById("123456"));

    }


    @Test
    public void deletePatient() {
        Patient patient = new Patient();
        patient.setFirstName("John");
        patient.setLastName("Doe");
        patient.setDateOfBirth("12/12/1990");
        patient.setPatientIdentifier("123456");
        patient.setIdNumber("123456");
        patient.setLocation("Nairobi");
        patient.setBirthCertificate("1232434");

        patientService.deletePatient("123456");
        when(patientRepository.findById("123456")).thenReturn(null);

    }
}