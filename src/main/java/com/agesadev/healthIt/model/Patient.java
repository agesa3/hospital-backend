package com.agesadev.healthIt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name = "patient_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    private String patientIdentifier;
    private String firstName;
    private String lastName;
    private String birthCertificate;
    private String idNumber;
    private String location;
    private String phoneNumber;
    private String dateOfBirth;
    private String gender;
}
