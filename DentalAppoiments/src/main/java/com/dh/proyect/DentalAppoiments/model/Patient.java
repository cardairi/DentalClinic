package com.dh.proyect.DentalAppoiments.model;

import java.time.LocalDate;


public class Patient {

    long id;
    private String name;
    private String lastName;
    private String address;
    private int dni;
    private LocalDate dischargeDate;


    public Patient(long id, String name, String lastName, int dni, LocalDate dischargeDate) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.dischargeDate = dischargeDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }
}
