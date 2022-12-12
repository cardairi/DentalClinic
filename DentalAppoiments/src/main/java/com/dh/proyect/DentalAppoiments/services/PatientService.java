package com.dh.proyect.DentalAppoiments.services;
import com.dh.proyect.DentalAppoiments.entities.Patient;
import com.dh.proyect.DentalAppoiments.exceptions.BadRequestException;
import com.dh.proyect.DentalAppoiments.exceptions.ResourceNotFoundException;
import com.dh.proyect.DentalAppoiments.repository.impl.PatientRepository;
import com.dh.proyect.DentalAppoiments.services.dto.PatientDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class PatientService implements IPatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    ObjectMapper mapper;

    //Logger methods
    private static final Logger LOGGER = Logger.getLogger(PatientService.class);

    // List patient
    @Override
    public Set<PatientDto> listPatients() {
        List<Patient> PatientEntityList = patientRepository.findAll();
        Set<PatientDto> patientDto = new HashSet<>();
        for (Patient p : PatientEntityList) {
            LOGGER.info("Patients was listed");
            patientDto.add(mapper.convertValue(p, PatientDto.class));

        }
        return patientDto;
    }

    //Creating patient
    @Override
    public PatientDto createPatient(PatientDto patientDto) {
        Patient patient = mapper.convertValue(patientDto, Patient.class);
        patientRepository.save(patient);
        PatientDto patientDto1 = mapper.convertValue(patient, PatientDto.class);
        LOGGER.info("Patient was created");
        return patientDto1;
    }


    //Find patient by id
    @Override
    public PatientDto findPatient(Long id) {
        PatientDto patientDto = null;
        Optional<Patient> patientDtoFound = patientRepository.findById(id);
        if (patientDtoFound.isPresent()) {
            LOGGER.info("The patient was found with id: " + id);
            return patientDto = mapper.convertValue(patientDtoFound, PatientDto.class);
        } else {
            LOGGER.info("No patient were found with id: " + id);
        }
        return patientDto;
    }


    //Modifying patient by id
    @Override
    public PatientDto modifyPatient(Long id, PatientDto patientDto) throws ResourceNotFoundException {
        PatientDto patientDtoModify = null;
        Optional<Patient> patientToModify = patientRepository.findById(id);
        if (patientToModify.isPresent()) {
            patientToModify.get().setName(patientDto.name != null ? patientDto.name : patientToModify.get().getName());
            patientToModify.get().setLastName(patientDto.lastName != null ? patientDto.lastName : patientToModify.get().getLastName());
            patientToModify.get().setDni(patientDto.lastName != null ? patientDto.dni : patientToModify.get().getDni());
            LOGGER.info("The patient was updated with id: " + id);
            patientDtoModify = mapper.convertValue(patientToModify, PatientDto.class);
        } else {
            LOGGER.error("No patient were found with id: " + id);
            throw new ResourceNotFoundException("The dentist  is not exist whit the id:" + id);
        }
        return patientDto;
    }

    // Delete patient by id
    @Override
    public void deletePatient(Long id) throws ResourceNotFoundException {
        PatientDto patientDtoDelete = null;
        Optional<Patient> patient = patientRepository.findById(id);
        if ( patient.isPresent()) {
            LOGGER.info("The patient was deleted");
            patientRepository.deleteById(id);
        } else {
            LOGGER.error("The patient was not found with id: " + id);
            throw new ResourceNotFoundException("The patient is not exist whit the id:" + id);
        }
    }
}
