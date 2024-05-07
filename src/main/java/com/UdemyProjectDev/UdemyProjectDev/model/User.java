package com.UdemyProjectDev.UdemyProjectDev.model;


import com.UdemyProjectDev.UdemyProjectDev.enums.UserRole;
import com.UdemyProjectDev.UdemyProjectDev.util.IdGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    private long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Schedule schedule;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    // TODO : handle special cases
    public User(String email, UserRole role, String phoneNumber) {
        this.id = Optional.ofNullable(email)
                .map(e -> IdGenerator.generateHash(e, role.toString(), phoneNumber))
                .orElseThrow(() -> new IllegalArgumentException("Email cannot be null"));
        this.email = email;
        this.userRole = Optional.of(role)
                .orElseThrow(() -> new IllegalArgumentException("Role cannot be null"));
        this.phoneNumber = Optional.ofNullable(phoneNumber)
                .orElseThrow(() -> new IllegalArgumentException("Phone number cannot be null"));
//        this.username = (lastName.charAt(0) + firstName).toLowerCase();
        this.username = email;
    }

}
