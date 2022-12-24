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
@Table(name = "avatar")
public class Avatar {
    // класс модель - иммитация аккаунта пользователя БД

    @Id
    private String id;

    @Column(name = "email")
    private String email;

    private String image;


}