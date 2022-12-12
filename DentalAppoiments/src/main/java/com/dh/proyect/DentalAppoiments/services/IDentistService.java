package com.dh.proyect.DentalAppoiments.services;

import com.dh.proyect.DentalAppoiments.exceptions.BadRequestException;
import com.dh.proyect.DentalAppoiments.exceptions.ResourceNotFoundException;
import com.dh.proyect.DentalAppoiments.services.dto.DentistDto;

import java.util.Set;

public interface IDentistService {

    // List dentist
    Set<DentistDto> listDentist() throws BadRequestException;

    // Creating dentist
DentistDto createDentist(DentistDto dentistDto);

    //Find dentist by id
DentistDto findDentist(Long id) throws ResourceNotFoundException;

    //Modifying dentist by id
    DentistDto modifyDentist(Long id, DentistDto dentistDto) throws ResourceNotFoundException;

    // Delete dentist by id
void deleteDentist(Long id) throws ResourceNotFoundException;

}
