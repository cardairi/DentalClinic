package com.dh.proyect.DentalAppoiments.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name= "patient" )
    public class Patient {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @SequenceGenerator(name = "patient_sequence",sequenceName = "patient_sequence",allocationSize = 1)
            private long id;

            private String name;

            private String lastName;
            private int dni;
            @ManyToOne(cascade = CascadeType.ALL)
           @JoinColumn(name = "address_id", referencedColumnName = "id")
            private Address  address;

            private LocalDate dischargeDate;

        @OneToMany(mappedBy = "patient")
        @JsonIgnore
        private Set<Appointment> appointments;

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni=" + dni +
                ", address=" + address +
                ", dischargeDate=" + dischargeDate +
                '}';
    }
}
