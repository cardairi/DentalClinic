package com.dh.proyect.DentalAppoiments.services.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class DentistDto {

    public Long id;
    public Integer registration;
    public String name;
    public String lastName;

}


