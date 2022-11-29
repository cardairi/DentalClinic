package com.dh.proyect.DentalAppoiments.repository;

import java.util.List;

public interface IDao<T> {

    //Listing
    List<T> list();

    //Creating dentist
    T save(T t);

    //Find records
    T findById(Long id);

    // Modifying records
    T modifyById(Long id);

    //Delete Dentist
    T deleteById(Long id);
}