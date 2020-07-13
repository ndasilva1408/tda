package com.p12.toitdesaines.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "client")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;
    private String nom;
    private String prenom;
    private Date birthday;
    private boolean droitImg;
    private String telephone;
    private String referent;
    private String referent_tel;
    private String caf;
    @ManyToOne
    private Maison maison;
    private String secuSociale;
    private String department;
    private String caisseRetraite;
    private Long medecinTraitant;
    private String others;
    private boolean en_attente;
    private Date premier_contact;
    private Date entree_prevue;
    private Date date_sortie;

}
