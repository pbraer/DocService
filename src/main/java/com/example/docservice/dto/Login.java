package com.example.docservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Login {
    private String id;
    private String email;
    private String pass;
    private String isdoc;


}
