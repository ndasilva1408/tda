package com.p12.toitdesaines.services;

import com.p12.toitdesaines.DTO.MedecinTraitantDTO;
import com.p12.toitdesaines.entity.MedecinTraitant;

import java.util.List;

public interface MedecinService {
    List<MedecinTraitant> getAll();

    MedecinTraitant createMedic(MedecinTraitantDTO medecinTraitantDTO);
    MedecinTraitant getMedic(Long id);
    void deleteMedic(Long id);
}
