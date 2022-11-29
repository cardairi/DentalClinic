package com.dh.proyect.DentalAppoiments.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Appointment {
    @Id
    @SequenceGenerator(name= "appointment_sequence", sequenceName = "appointment_sequence", allocationSize = 1)
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_sequence")
    private Long id;
    @ManyToOne
    @JoinColumn(name =  "dentist_id")
    private Dentist dentist;
    @ManyToOne
    @JoinColumn(name =  "patient_id")
    private Patient patient;

    private LocalDate date;

    public Appointment(Long id, Dentist dentist, Patient patient, LocalDate date) {
        this.id = id;
        this.dentist = dentist;
        this.patient = patient;
        this.date = date;
    }

    public Appointment(Dentist dentist, Patient patient, LocalDate date) {
        this.dentist = dentist;
        this.patient = patient;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
