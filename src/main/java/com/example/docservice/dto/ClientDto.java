package com.example.docservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

    private long id;
    private String qualif;
    private String firstname;
    private String lastname;
    private String middlename;
    private String date;
    private String time;

}