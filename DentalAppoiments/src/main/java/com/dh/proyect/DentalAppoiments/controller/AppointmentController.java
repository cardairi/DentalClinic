package com.dh.proyect.DentalAppoiments.controller;


import com.dh.proyect.DentalAppoiments.entities.Appointment;
import com.dh.proyect.DentalAppoiments.exceptions.ResourceNotFoundException;
import com.dh.proyect.DentalAppoiments.services.AppointmentService;
import com.dh.proyect.DentalAppoiments.services.DentistService;
import com.dh.proyect.DentalAppoiments.services.PatientService;
import com.dh.proyect.DentalAppoiments.services.dto.AppointmentDto;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/appointment")

public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    PatientService patientService;

    @Autowired
    DentistService dentistService;

    private static final Logger LOGGER = LogManager.getLogger(AppointmentController.class);

    //Create a new Appointment
    @PostMapping("/create")
        public ResponseEntity<AppointmentDto> registerANewAppointment(@RequestBody AppointmentDto appointmentDto) {
            Appointment appointmentSaved = null;
            ResponseEntity<AppointmentDto> response;
            if (patientService.findPatient(appointmentDto.patient.getId()) == null && dentistService.findDentist(appointmentDto.dentist.getId()) == null) {
                LOGGER.info("The appointment was not created");
                response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            } else {
                response = ResponseEntity.ok(appointmentService.createAppointment(appointmentDto));
                LOGGER.info("The appointment was created");
            }
            return response;
    }

    // List of appointment
    @GetMapping("/list")
            public ResponseEntity<Set<AppointmentDto>> listAppointment() {
                if (appointmentService.listAppointment().isEmpty()){
                    LOGGER.error("There are no turns to list.");
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                }
                LOGGER.info(String.format("List of existing appointment.", appointmentService.listAppointment().size()));
                return ResponseEntity.ok(appointmentService.listAppointment());
            }

        //Find the appointment
    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDto> findAppointmentById(@PathVariable("id") Long id) {
                ResponseEntity<AppointmentDto> appointmentDtoResponseEntity = null;
                if (dentistService.findDentist(id) == null) {
                    LOGGER.error("The appointment was not found with id: " + id);
                    appointmentDtoResponseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
                } else {
                    LOGGER.info("The appointment was found with id: " + id);
                    appointmentDtoResponseEntity = new ResponseEntity<>(appointmentService.findAppointment(id), HttpStatus.OK);
                }
                return appointmentDtoResponseEntity;
        }
    //modifying appointment
    @PutMapping("update/{id}")
    public ResponseEntity<AppointmentDto> modifyingAppointment(@PathVariable Long id, @RequestBody AppointmentDto appointmentDto) throws  ResourceNotFoundException, Exception {
            LOGGER.info("The appointment was found and modified with id: " + id);
        return ResponseEntity.ok(appointmentService.modifyAppointment(id, appointmentDto));
    }

    //removing appointment

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Long id) throws ResourceNotFoundException, Exception {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.status(HttpStatus.OK).body("The appointment was eliminated");
    }



    }



