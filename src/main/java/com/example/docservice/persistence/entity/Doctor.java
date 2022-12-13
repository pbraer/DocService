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

    private String userid;

    @Column(name = "email")
    private String email;

    private String pass;
    private String firstname;
    private String lastname;
    private String middlename;
    private String qualif;
    private String image;
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private String saturday;
    private String sunday;
    private String timefrom;
    private String timeto;


}

