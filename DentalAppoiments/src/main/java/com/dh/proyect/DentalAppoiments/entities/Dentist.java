package com.dh.proyect.DentalAppoiments.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name= "dentist" )

public class Dentist {
                @Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                @SequenceGenerator(name = "dentist_sequence",sequenceName = "dentist_sequence",allocationSize = 1)
                private long id;

                private int registration;

                private String name;

                private String lastName;

                @OneToMany(mappedBy = "dentist")
                @JsonIgnore
                private Set<Appointment> appointments;

                @Override
    public String toString() {
        return "Dentist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", registration=" + registration +
                '}';
    }
}
