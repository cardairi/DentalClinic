package com.dh.proyect.DentalAppoiments.controller;
import com.dh.proyect.DentalAppoiments.exceptions.ResourceNotFoundException;
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

    //Creating a new patient
    @PostMapping("/create")
    public ResponseEntity<PatientDto> registerANewPatient(@RequestBody PatientDto patientDto) {
        LOGGER.info("The patient was created");

        return ResponseEntity.ok(patientService.createPatient(patientDto));
    }

    // List of patient
    @GetMapping("/list")
    public ResponseEntity <Set<PatientDto>> listPatient() {
        LOGGER.info("The patients were listed");
        return ResponseEntity.ok(patientService.listPatients());
    }

    //Finding Dentist
    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> findPatientById(@PathVariable Long id, @RequestBody PatientDto patientDto) throws ResourceNotFoundException {
        LOGGER.info("The patient was found with id: " + id);
       return ResponseEntity.ok(patientService.findPatient(id));
    }

    //modifying dentists
    @PutMapping("update/{id}")
    public ResponseEntity<PatientDto> modifyingPatient(@PathVariable Long id, @RequestBody PatientDto patientDto) throws ResourceNotFoundException, Exception{
        LOGGER.info("The patient was updated with id: " + id);
        return ResponseEntity.ok(patientService.modifyPatient(id, patientDto));
    }

    //Delete Dentist

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) throws ResourceNotFoundException, Exception {
        patientService.deletePatient(id);
        LOGGER.info("The patient was successfully deleted");
        return ResponseEntity.status(HttpStatus.OK).body("The patient was eliminated");
    }
}
