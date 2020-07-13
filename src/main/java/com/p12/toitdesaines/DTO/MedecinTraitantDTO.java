package com.p12.toitdesaines.DTO;

import lombok.*;

@Data

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

public class MedecinTraitantDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String tel;
}
