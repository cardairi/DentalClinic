package com.dh.proyect.DentalAppoiments.controller;
import com.dh.proyect.DentalAppoiments.services.PatientService;
import com.dh.proyect.DentalAppoiments.services.dto.PatientDto;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/patient")

public class PatientController {

    @Autowired
    private PatientService patientService;
    private static final Logger LOGGER = LogManager.getLogger(PatientController.class);

    //Creating a new dentist
    @PostMapping("/create")
    public ResponseEntity<PatientDto> registerANewPatient(@RequestBody PatientDto patientDto) {
        LOGGER.info("The patient was created");
        return ResponseEntity.ok(patientService.createPatient(patientDto));
    }

    // List of dentist
    @GetMapping("/list")
    public ResponseEntity <Set<PatientDto>> listPatient() {
        LOGGER.info("The patients were listed");
        return ResponseEntity.ok(patientService.listPatients());
    }

    //Fining Dentist
    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> findPatientById(@PathVariable("id") Long id) {
        ResponseEntity<PatientDto> patientDtoResponseEntity = null;
        if (patientService.findPatient(id) == null) {
            LOGGER.error("The patient was not found with id: " + id);
            patientDtoResponseEntity  = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            LOGGER.error("The patient was found with id: " + id);
            patientDtoResponseEntity  = new ResponseEntity<>(patientService.findPatient(id), HttpStatus.OK);
        }
        return patientDtoResponseEntity ;

    }

    //modifying dentists
    @PutMapping("update/{id}")
    public ResponseEntity<PatientDto> modifyingPatient(@PathVariable Long id, @RequestBody PatientDto patientDto) {
    ResponseEntity<PatientDto> patientDtoResponseEntity = null;
        if (patientService.findPatient(id) != null) {
            LOGGER.error("The dentist was found and modified with id: " + id);
            patientDtoResponseEntity = new ResponseEntity (patientService.modifyPatient(id, patientDto), HttpStatus.OK);
        } else {
            LOGGER.info("The dentist wasn't found and modify with id: " + id);
        patientDtoResponseEntity= new ResponseEntity (HttpStatus.NOT_FOUND);
        }
        return patientDtoResponseEntity;
    }

    //Delete Dentist
    @DeleteMapping("delete/{id}")
    public ResponseEntity<PatientDto> deletePatient(@PathVariable Long id) {
        ResponseEntity<PatientDto> patientDtoResponseEntity = null;
        if (patientService.findPatient(id) == null) {
            LOGGER.error("The patient was not found with id: " + id);
            patientDtoResponseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            patientService.deletePatient(id);
            patientDtoResponseEntity = new ResponseEntity(HttpStatus.NO_CONTENT);
            LOGGER.info("The patient was eliminated with: " + id);
        }
        return patientDtoResponseEntity;
    }

}
