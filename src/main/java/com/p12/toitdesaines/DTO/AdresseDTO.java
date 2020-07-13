package com.p12.toitdesaines.DTO;

import lombok.*;

@Data

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

public class AdresseDTO {
    private Long id;
    private String rue;
    private String departement;

}
