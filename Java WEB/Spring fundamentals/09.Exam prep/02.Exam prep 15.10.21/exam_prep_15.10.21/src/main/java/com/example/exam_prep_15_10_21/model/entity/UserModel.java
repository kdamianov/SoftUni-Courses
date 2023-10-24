package com.example.exam_prep_15_10_21.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class UserModel extends BaseEntity {
//    •	Has a Username (unique)
//          o	The length of the username must be between 5 and 20 characters (both numbers are INCLUSIVE).
//    •	Has a First Name
//          o	Can be null.
//    •	Has a Last Name
//          o	The length of the last name must be between 5 and 20 characters (both numbers are INCLUSIVE).
//    •	Has a Password
//          o	The length of the password must be more than 3 (INCLUSIVE).
//    •	Has an Email
//          o	Must contain a '@' symbol.
//          o	The email must be UNIQUE!!!!!! //TODO
    @Column(nullable = false, unique = true)
    private String username;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String password;
    @Email
    @Column(nullable = false)
    private String email;


    public UserModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserModel setEmail(String email) {
        this.email = email;
        return this;
    }
}
