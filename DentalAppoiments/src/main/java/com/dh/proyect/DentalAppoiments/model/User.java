package com.dh.proyect.DentalAppoiments.model;

public class User {
    private Long id;
    private String name;
    private String email;
    private String userName;
    private String password;
    private UserRol rol;


    public User(String name, String email, String userName, String password, UserRol rol) {
        this.name = name;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserRol getRol() {
        return rol;
    }

    public void setRol(UserRol rol) {
        this.rol = rol;
    }
}
