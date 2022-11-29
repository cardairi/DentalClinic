package com.dh.proyect.DentalAppoiments.services;
import com.dh.proyect.DentalAppoiments.entities.Dentist;
import com.dh.proyect.DentalAppoiments.entities.Patient;
import com.dh.proyect.DentalAppoiments.repository.impl.PatientRepository;
import com.dh.proyect.DentalAppoiments.services.dto.PatientDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PatientService implements IPatientService {

    @Autowired
    private PatientRepository patientRepository;
    private static final Logger LOGGER = Logger.getLogger(PatientService.class);

    // List patient

    @Override
    public List<Patient> listPatients() {
        return patientRepository.findAll();
    }

    @Autowired
    ObjectMapper mapper;

    //Creating patient
    @Override
    public Patient createPatient(PatientDto patientDto) {
        Patient newPatient = mapper.convertValue(patientDto, Patient.class);
        return patientRepository.save(newPatient);
    }

    //Find patient by id
    @Override
    public Optional<Patient> findPatient(Long id) {
        return patientRepository.findById(id);
    }

    //Modifying patient by id
    @Override
    public Patient modifyPatient(Long id, PatientDto patientDto) {
        Optional<Patient> patientToModify = findPatient(id);
        if (patientToModify.isPresent()) {
            patientToModify.get().setName(patientDto.name != null ? patientDto.name : patientToModify.get().getName());
            patientToModify.get().setLastName(patientDto.lastName != null ? patientDto.lastName : patientToModify.get().getLastName());
        }
        return patientRepository.save(patientToModify.get());
    }

    // Delete patient by id
    @Override
    public boolean deletePatient(Long id) {
        Optional<Patient> patient = findPatient(id);
        if (patient.isPresent()) {
            patientRepository.deleteById(id);
        }
        return false;
    }
}

