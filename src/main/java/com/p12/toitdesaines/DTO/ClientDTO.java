package com.p12.toitdesaines.DTO;

import com.p12.toitdesaines.entity.Maison;
import com.p12.toitdesaines.entity.MedecinTraitant;
import lombok.*;

import java.sql.Blob;
import java.util.Date;

@Data

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

public class ClientDTO {
    private Long id;
    private String nom;
    private String prenom;
    private Date birthday;
    private boolean droitImg;
    private byte[] photos;
    private String telephone;
    private String referent;
    private String referent_tel;
    private String caf;
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
