package com.example.docservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

    private String id;
    private String email;
    private String pass;
    private String qualif;
    private String firstname;
    private String lastname;
    private String middlename;
    private String dateAppoitm;
    private String timeAppoitm;

}