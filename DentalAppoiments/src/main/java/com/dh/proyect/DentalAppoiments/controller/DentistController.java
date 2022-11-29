package com.dh.proyect.DentalAppoiments.controller;

import com.dh.proyect.DentalAppoiments.services.DentistService;
import com.dh.proyect.DentalAppoiments.services.dto.DentistDto;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/dentist")

public class DentistController {

    @Autowired
    private DentistService dentistService;
    private static final Logger LOGGER = LogManager.getLogger(DentistController.class);

    //Creating a new dentist
    @PostMapping("/create")
    public ResponseEntity<DentistDto> registrarNuevoOdontologo(@RequestBody DentistDto dentistDto) {
        return ResponseEntity.ok(dentistService.createDentist(dentistDto));
    }

    // List of dentist
    @GetMapping
    public Set<DentistDto> listDentist() {
        return dentistService.listDentist();
    }

    //Fining Dentist
    @GetMapping("/{id}")
    public ResponseEntity<DentistDto> findDentistById(@PathVariable("id") Long id) {
        ResponseEntity<DentistDto> dentistDtoResponseEntity = null;
        if (dentistService.findDentist(id) == null) {
            LOGGER.error("The dentist was not found with id: " + id);
            dentistDtoResponseEntity = new ResponseEntity<DentistDto>(HttpStatus.NOT_FOUND);
        } else {
            LOGGER.error("The dentist was found with id: " + id);
            dentistDtoResponseEntity = new ResponseEntity<DentistDto>(dentistService.findDentist(id), HttpStatus.OK);
        }
        return dentistDtoResponseEntity;

    }

    //modifying dentists
    @PutMapping("update/{id}")
    public ResponseEntity<DentistDto> modifyingDentist(@PathVariable Long id, @RequestBody DentistDto dentistDto) {
        ResponseEntity<DentistDto> dentistDtoResponseEntity = null;
        if (dentistService.findDentist(id) == null) {
            LOGGER.error("The dentist was not found with id: " + id);
            dentistDtoResponseEntity = new ResponseEntity (HttpStatus.NOT_FOUND);
        } else {
            LOGGER.info("The dentist was found and modify with id: " + id);
            dentistDtoResponseEntity = new ResponseEntity (dentistService.modifyDentist(id, dentistDto), HttpStatus.OK);
        }
        return dentistDtoResponseEntity;
    }

    //Delete Dentist
    @DeleteMapping("delete/{id}")
    public ResponseEntity<DentistDto> deleteDentist(@PathVariable Long id) {
        ResponseEntity<DentistDto> dentistDtoResponseEntity = null;
        if (dentistService.findDentist(id) == null) {
            LOGGER.error("The dentist was not found with id: " + id);
            dentistDtoResponseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            dentistService.deleteDentist(id);
            dentistDtoResponseEntity = new ResponseEntity(HttpStatus.NO_CONTENT);
            LOGGER.info("The dentist was eliminated with: " + id);
        }
            return dentistDtoResponseEntity;
    }

}
