package com.p12.toitdesaines.DTO;

import com.p12.toitdesaines.entity.Client;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class IntervenantDTO {
    private Long id;
    private String profession;
    private String nom;
    private String prenom;
    private String tel;
    private String mail;
    private AdresseDTO adresse;
    private List<Client> client;
}
