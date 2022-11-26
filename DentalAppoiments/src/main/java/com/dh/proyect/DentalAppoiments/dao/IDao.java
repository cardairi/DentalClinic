package com.dh.proyect.DentalAppoiments.dao;

import com.dh.proyect.DentalAppoiments.model.Dentist;

import java.util.List;
import java.util.Optional;

public interface IDao<T> {

    //Listing
    List<T> list();

    //Creating dentist
    T create(T t);

    //Saving records
    T saveById (Long id);

    //Find records
    T findById(Long id);

    // Modifying records
    T modifyById(Long id);

    //Delete Dentist
    T deleteById(Long id);
}