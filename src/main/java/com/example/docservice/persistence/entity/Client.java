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
    private String email;
    private String pass;
    private String qualif = null;
    private String firstname = null;
    private String lastname = null;
    private String middlename = null;
    private String date = null;
    private String time = null;


}