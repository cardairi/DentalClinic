package com.dh.proyect.DentalAppoiments.entities;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@Entity
public class Appointment {
        @Id
        @SequenceGenerator(name = "turno_sequence", sequenceName = "turno_sequence", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_sequence")
        private Long id;

        @ManyToOne
        @JoinColumn(name =  "patient_id",  nullable = false)
        private Patient patient;

        @ManyToOne
        @JoinColumn(name =  "dentist_id", nullable = false)
        private Dentist dentist;

        private LocalDate dischargeDate;


//        public Appointment(Long id, Patient patient, Dentist dentist, LocalDate dischargeDate) {
//                this.id = id;
//                this.patient = patient;
//                this.dentist = dentist;
//                this.dischargeDate = dischargeDate;
//        }
}
