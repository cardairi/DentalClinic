package com.dh.proyect.DentalAppoiments.services;

import com.dh.proyect.DentalAppoiments.services.dto.DentistDto;

import java.util.Set;

public interface IDentistService {

    // List dentist
    Set<DentistDto> listDentist();

    // Creating dentist
DentistDto createDentist(DentistDto dentistDto);

    //Find dentist by id
DentistDto findDentist(Long id);

    //Modifying dentist by id
    DentistDto modifyDentist(Long id, DentistDto dentistDto);

    // Delete dentist by id
void deleteDentist(Long id);

}
