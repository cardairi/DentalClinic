package com.dh.proyect.DentalAppoiments.model;

public class Dentist {
    private long id;
    private int registration;
    private String name;
    private String lastName;



    public Dentist(long id,int registration, String name, String lastName ) {
        this.id = id;
        this.registration = registration;
        this.name = name;
        this.lastName = lastName;

    }

    public Dentist(int registration, String name, String lastName) {
        this.registration = registration;
        this.name = name;
        this.lastName = lastName;
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

    public int getRegistration() {
        return registration;
    }

    public void setRegistration(int registration) {
        this.registration = registration;
    }

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
