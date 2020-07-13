package com.p12.toitdesaines.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Simapa {
    private int gir;
    private boolean isAlone;
    private int revenus;
    private double estimation;
    private double plafondGIR;
    private double participation;
}
