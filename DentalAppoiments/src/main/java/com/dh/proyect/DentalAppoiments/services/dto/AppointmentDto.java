package com.dh.proyect.DentalAppoiments.services.dto;

import com.dh.proyect.DentalAppoiments.entities.Dentist;
import com.dh.proyect.DentalAppoiments.entities.Patient;

import java.time.LocalDate;

public class AppointmentDto {
    public Long id;
    public Long patientId;
    public Long dentistId;
    public LocalDate date;

}
