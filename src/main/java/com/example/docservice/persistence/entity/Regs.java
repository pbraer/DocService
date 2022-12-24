package com.example.docservice.persistence.entity;

import jakarta.persistence.Column;
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
    @Column(name = "email")
    private String email;
    private String lastdate;
    private String lasttime;
    private String futuredate;
    private String futuretime;

}
