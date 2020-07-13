package com.p12.toitdesaines.DTO;

import com.p12.toitdesaines.entity.Client;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class MaisonDTO {
    private Long id;
    private String adress;
    private int capacite;
    private List<Client> clients;

}
