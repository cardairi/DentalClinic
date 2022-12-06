package com.dh.proyect.DentalAppoiments.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name= "address" )

public class Address {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;
            private String street;
            private int number;
            private String city;

    @OneToMany(mappedBy = "address")
    @JsonIgnore
    private Set<Patient> patients;

}

