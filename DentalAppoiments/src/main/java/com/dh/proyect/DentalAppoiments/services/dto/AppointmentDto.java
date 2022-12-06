package com.dh.proyect.DentalAppoiments.services.dto;

import com.dh.proyect.DentalAppoiments.entities.Dentist;
import com.dh.proyect.DentalAppoiments.entities.Patient;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Getter
@Setter
@Component
public class AppointmentDto {
    public Long id;
    public Patient patient;
    public Dentist dentist;
    public LocalDate dischargeDate;

}
