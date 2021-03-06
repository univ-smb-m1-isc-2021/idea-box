package com.example.ideabox.User;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String email;

    @Column
    private String hashpassword;

    @Column
    private String pseudo;

    @Column
    private String lastName;

    @Column
    private String firstName;


    public User() {
        // Pour JPA
    }

    public User(String email, String hashpassword, String pseudo, String lastName, String firstName) {
        this.email = email;
        this.hashpassword = hashpassword;
        this.pseudo = pseudo;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashpassword() {
        return hashpassword;
    }

    public void setHashpassword(String hashpassword) {
        this.hashpassword = hashpassword;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", hashpassword='" + hashpassword + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
