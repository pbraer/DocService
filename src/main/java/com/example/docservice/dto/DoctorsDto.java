package com.example.docservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorsDto {

    private String id;
    private String userid;
    private String email;
    private String pass;
    private String firstname = null;
    private String lastname = null;
    private String middlename = null;
    private String qualif = null;
    private Boolean monday = false;
    private Boolean tuesday = false;
    private Boolean wednesday = false;
    private Boolean thursday = false;
    private Boolean friday = false;
    private Boolean saturday = false;
    private Boolean sunday = false;
    private String timefrom = null;
    private String timeto = null;
    private String image = null;

}