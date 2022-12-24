package com.example.docservice.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "documents")
public class ClientFiles {
    @Id
    private String id;


    private String clientid;
    private String docid;
    private String datemeet;
    private String doctor;
    private String filename;


}