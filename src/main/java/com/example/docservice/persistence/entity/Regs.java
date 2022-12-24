package com.example.docservice.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name = "usertable")
@Data
public class Regs {
    @Id
    private String id;
    private String userid;
    private String email;
    private String lastdate;
    private String lasttime;
    private String futuredate;
    private String futuretime;

}