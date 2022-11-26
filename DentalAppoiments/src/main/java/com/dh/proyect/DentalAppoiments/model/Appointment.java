package com.dh.proyect.DentalAppoiments.model;

import java.time.LocalDate;

public class Appointment {
    private Long id;

    private Dentist dentist;
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
