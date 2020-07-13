package com.p12.toitdesaines.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Intervenant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String profession;
    private String nom;
    private String prenom;
    private String tel;
    @ManyToOne
    private Adresse adresse;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "client_intervenant",
            joinColumns = @JoinColumn(name = "intervenant_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id"))
    private List <Client> client;
}
