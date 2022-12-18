package com.example.docservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

    private String id;
    private String userid;
    private String email;
    private String pass;
    private String qualif;
    private String doctor;
    private String dateappoitm;
    private String timeappoitm;

}