package com.dh.proyect.DentalAppoiments.controller;
import com.dh.proyect.DentalAppoiments.exceptions.BadRequestException;
import com.dh.proyect.DentalAppoiments.exceptions.ResourceNotFoundException;
import com.dh.proyect.DentalAppoiments.services.DentistService;
import com.dh.proyect.DentalAppoiments.services.dto.DentistDto;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;


@RestController
@RequestMapping("/dentist")

public class DentistController {

    @Autowired
    private DentistService dentistService;
    private static final Logger LOGGER = LogManager.getLogger(DentistController.class);

    //Creating a new dentist
    @PostMapping("/create")
    public ResponseEntity<DentistDto>registerANewPatient(@RequestBody DentistDto dentistDto) {
        LOGGER.info("The dentist was created");
        return ResponseEntity.ok(dentistService.createDentist(dentistDto));
    }

    // List of dentist
    @GetMapping("/list")
    public ResponseEntity< Set<DentistDto>> listDentist() throws BadRequestException, Exception {
        LOGGER.info("The dentists were listed");
        return ResponseEntity.ok(dentistService.listDentist());
    }

    //Finding Dentist
    @GetMapping("/{id}")
    public ResponseEntity<DentistDto> findDentistById(@PathVariable Long id, @RequestBody DentistDto dentistDto) throws ResourceNotFoundException {
        LOGGER.info("The dentist was found with id: " + id);
        return ResponseEntity.ok(dentistService.findDentist(id));
    }

    //modifying dentists
    @PutMapping("update/{id}")
    public ResponseEntity<DentistDto> modifyingDentist(@PathVariable Long id, @RequestBody DentistDto dentistDto) throws ResourceNotFoundException, Exception {
        LOGGER.info("The dentist was updated with id: " + id);
        return ResponseEntity.ok(dentistService.modifyDentist(id, dentistDto));
    }


    //Delete Dentist
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteDentist(@PathVariable Long id) throws ResourceNotFoundException, Exception {
        dentistService.deleteDentist(id);
        LOGGER.info("The dentist was successfully deleted");
        return ResponseEntity.status(HttpStatus.OK).body("The dentist was eliminated");
    }

}
