package com.p12.toitdesaines.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Maison implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Adresse adresse;
    private int capacite;
 /*   @OneToMany(mappedBy = "maison",fetch = FetchType.LAZY)
    private List<Client> clients;
*/
}
