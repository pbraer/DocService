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
    private String firstname;
    private String lastname;
    private String middlename;
    private String qualif;
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private String saturday;
    private String sunday;
    private String timefrom;
    private String timeto;
    private String image;

}