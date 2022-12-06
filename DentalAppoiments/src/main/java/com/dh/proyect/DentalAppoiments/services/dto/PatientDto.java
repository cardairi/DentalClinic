package com.dh.proyect.DentalAppoiments.services.dto;

import com.dh.proyect.DentalAppoiments.entities.Patient;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Getter
@Setter
@Component
public class PatientDto {
    public Long id;
    public String name;
    public String lastName;
    public String address;
    public int dni;
    private LocalDate dischargeDate;

}