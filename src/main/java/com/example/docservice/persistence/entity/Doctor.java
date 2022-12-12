package com.example.docservice.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@SelectBeforeUpdate
@DynamicUpdate
@Getter
@Setter
@Entity
@Table(name = "doctors")
public class Doctor {
    // класс модель - иммитация аккаунта пользователя БД

    @Id
    private String id; // ключ - уникальный id
    @Column(name = "email")
    private String email;

    private String pass;
    private String firstname;
    private String lastname;
    private String middlename = null;
    private String qualif = null;
    private String image = null;
    private Boolean monday = false;
    private Boolean tuesday = false;
    private Boolean wednesday = false;
    private Boolean thursday = false;
    private Boolean friday = false;
    private Boolean saturday = false;
    private Boolean sunday = false;
    private String timeFrom = null;
    private String timeTo = null;


}

