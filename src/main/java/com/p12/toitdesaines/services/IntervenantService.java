package com.p12.toitdesaines.services;

import com.p12.toitdesaines.DTO.IntervenantDTO;
import com.p12.toitdesaines.entity.Intervenant;

import java.util.List;

public interface IntervenantService {
    List<Intervenant> getInters();
    Intervenant getInter(Long id);
    void deleteInter(Long id);

    Intervenant createInters(IntervenantDTO intervenantDTO);
}
