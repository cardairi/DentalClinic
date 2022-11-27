package com.dh.proyect.DentalAppoiments.controller;
import com.dh.proyect.DentalAppoiments.model.Dentist;
import com.dh.proyect.DentalAppoiments.repository.impl.DentistRepository;
import com.dh.proyect.DentalAppoiments.services.DentistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentist")

public class DentistController {
    private final DentistService dentistService = new DentistService(new DentistRepository());

    @PostMapping
    public  Dentist registerDentist(@RequestBody Dentist dentist) {
        return dentistService.saveDentist(dentist);
    }

    @GetMapping
    public List<Dentist> listDentist() {
        return dentistService.listDentist();
    }
}



