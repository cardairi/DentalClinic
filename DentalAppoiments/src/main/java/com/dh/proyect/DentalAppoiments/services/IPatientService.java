package com.dh.proyect.DentalAppoiments.services;
import com.dh.proyect.DentalAppoiments.entities.Patient;
import com.dh.proyect.DentalAppoiments.exceptions.BadRequestException;
import com.dh.proyect.DentalAppoiments.exceptions.ResourceNotFoundException;
import com.dh.proyect.DentalAppoiments.services.dto.PatientDto;

import java.util.List;
import java.util.Set;

public interface IPatientService {

    //List Patient
    Set<PatientDto> listPatients();

    // Creating patient
    PatientDto createPatient(PatientDto patientDto) throws BadRequestException;

    //Find  patient by id
    PatientDto findPatient(Long id);

    //Modifying dentist by id
    PatientDto modifyPatient(Long id, PatientDto patientDto) throws ResourceNotFoundException;
    // Delete dentist by id
    void deletePatient(Long id) throws ResourceNotFoundException;

}

