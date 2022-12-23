package com.example.docservice.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "patientsappoitm")
public class Client {
    @Id
    private String id;

    private String userid;
    @Column(name = "email")
    private String email;
    private String pass;
    private String qualif;
    private String doctorid;
    private String doctor;
    private String dateappoitm;
    private String timeappoitm;


}