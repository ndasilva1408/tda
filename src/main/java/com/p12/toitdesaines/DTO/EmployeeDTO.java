package com.p12.toitdesaines.DTO;

import lombok.*;

import java.util.Date;

@Data

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

public class EmployeeDTO {
    private Long id;
    private String nom;
    private String prenom;
    private Date birthdate;
    private double salaire;
    private double heure;
    private String tel;
    private String mail;
    private String photo;
    private String profession;
    private boolean droitImg;
}
