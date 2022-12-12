package com.dh.proyect.DentalAppoiments.entities.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;


@Getter
@Setter
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "user_sequence")
    @SequenceGenerator(name = "user_sequence",sequenceName = "user_sequence",allocationSize = 1)

    private Long id;
    private String name;
    private String email;
    private String userName;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRol userRol;


    public User() {
    }

    public User(String name, String email, String userName, String password, UserRol userRol) {
        this.name = name;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.userRol = userRol;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userRol.name());
        return Collections.singletonList( grantedAuthority);
    }

    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}