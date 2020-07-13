package com.p12.toitdesaines.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data

public class ClientLobs {
    @Id
    private Long id;

    @OneToOne
    @MapsId
    private Client client;

    @Lob
    private byte[] photos;
}
