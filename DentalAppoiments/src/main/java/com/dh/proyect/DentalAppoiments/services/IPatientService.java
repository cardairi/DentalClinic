package com.dh.proyect.DentalAppoiments.services;
import com.dh.proyect.DentalAppoiments.entities.Patient;
import com.dh.proyect.DentalAppoiments.services.dto.PatientDto;

import java.util.List;
import java.util.Optional;

public interface IPatientService {
    List<Patient> listPatients();

    // Creating patient
    Patient createPatient(PatientDto patientDto);

    //Find patient by id
    Optional<Patient> findPatient(Long id);

    //Modifying patient by id
   Patient modifyPatient(Long id, PatientDto patientDto);

    // Delete patient by id
    boolean deletePatient(Long id);


}
