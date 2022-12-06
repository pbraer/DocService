package com.example.docservice.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "patientsappoitm")
public class Client {
    @Id
    private UUID id;

    @Column(name = "email")
    private String pass;
    private String email;
    private String qualif;
    private String firstname;
    private String lastname;
    private String middlename;
    private String date;
    private String time;

}