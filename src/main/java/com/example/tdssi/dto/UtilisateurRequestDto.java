package com.example.tdssi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
public class UtilisateurRequestDto {
    public  String  email;
    public String password;

}
