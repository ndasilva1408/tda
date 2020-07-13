package com.p12.toitdesaines.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "Employee")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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
