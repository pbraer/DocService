package com.example.docservice.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "usertable")
@Data
public class User {
    @Id
    private UUID id;
    @Column(name = "email")
    private String email;
    private String pass;
    private Boolean isdoc;


}
