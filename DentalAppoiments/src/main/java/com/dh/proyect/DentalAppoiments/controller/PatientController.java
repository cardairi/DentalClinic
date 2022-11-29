//package com.dh.proyect.DentalAppoiments.controller;
//import com.dh.proyect.DentalAppoiments.entities.Patient;
//import com.dh.proyect.DentalAppoiments.services.PatientService;
//import com.dh.proyect.DentalAppoiments.services.dto.PatientDto;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//@RestController
//@RequestMapping("/patient")
//
//
//public class PatientController {
//    private PatientService patientService;
//    private static final Logger LOGGER = LogManager.getLogger(PatientController.class);
//
//
//    //Creating a new dentist
//    @PostMapping
//    public ResponseEntity<PatientDto> createPatient(@RequestBody PatientDto patientDto) {
//        LOGGER.info("A new patient was created");
//        return ResponseEntity.ok(mapEntityToDto(patientService.createPatient(patientDto)));
//    }
//    // List of dentist
//    @GetMapping
//    public  ResponseEntity <List<PatientDto>> listPatient() {
//        List<PatientDto> patientDtos = new ArrayList<>();
//        LOGGER.info("List of patients");
//        for (Patient p : patientService.listPatients()) {
//            patientDtos.add(mapEntityToDto(p));
//        }
//        return ResponseEntity.ok(patientDtos);
//    }
//
//    //Fining Dentist
//    @GetMapping("/{id}")
//    public ResponseEntity <Patient> findingPatientById (@PathVariable Long id, @RequestBody PatientDto patientDto)  {
//        Optional<Patient> patientToFound = patientService.findPatient(patientDto.getId());
//        if  (patientToFound.isPresent()){
//            LOGGER.info("The patient was found with id: " + id);
//            return ResponseEntity.ok(patientToFound.get());
//        }
//        else{
//            LOGGER.info("No patient was found with id: " + id);
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }
//
//    //modifying dentists
//    @PutMapping ("update/{id}")
//    public ResponseEntity<Patient> modifyingPatient (@PathVariable Long id, @RequestBody PatientDto patientDto) {
//        Optional<Patient> patientToModify = patientService.findPatient(patientDto.getId());
//        if (patientToModify.isPresent()) {
//            LOGGER.info("The patient was updated with id: " + id);
//            return ResponseEntity.ok(patientService.modifyPatient(id, patientDto));
//        } else {
//            LOGGER.error("No patient was found with id: " + id);
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }
//    //Delete Dentist
//    @DeleteMapping( "delete/{id}")
//    public ResponseEntity<PatientDto> deletePatient(@PathVariable Long id) {
//        if (patientService.deletePatient(id)){
//            LOGGER.info("The patient was eliminated with: " + id);
//            return ResponseEntity.status(HttpStatus.OK).build();
//        } else {
//            LOGGER.error("The patient was not found with id: " + id);
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }
//
//    private PatientDto mapEntityToDto(Patient patientEntity) {
//        PatientDto patientDto = new PatientDto();
//        patientDto.id = patientEntity.getId();
//        patientDto.name = patientEntity.getName();
//        patientDto.lastName = patientEntity.getLastName();
//        patientDto.dni = patientEntity.getDni();
//        return patientDto;
//    }
//}
//
