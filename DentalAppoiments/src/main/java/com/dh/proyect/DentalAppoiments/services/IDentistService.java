package com.dh.proyect.DentalAppoiments.services;

import com.dh.proyect.DentalAppoiments.model.Dentist;

import java.util.List;

public interface IDentistService {

    // List dentist
    List<Dentist> listDentist();

    // Creating dentist
    Dentist createDentist(Dentist dentist);

    // Save patient by id
    Dentist saveDentistById(Long id);

    //Find dentist by id
    Dentist findDentist(Long id);

    //Modifying dentist by id
    Dentist modifyDentist(Long id);

    // Delete dentist by id
void deleteDentist(Long id);

}
