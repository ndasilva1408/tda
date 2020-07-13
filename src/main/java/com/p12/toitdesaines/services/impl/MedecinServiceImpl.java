package com.p12.toitdesaines.services.impl;

import com.p12.toitdesaines.DAO.MedecinTraitantRepository;
import com.p12.toitdesaines.DTO.AdresseDTO;
import com.p12.toitdesaines.DTO.IntervenantDTO;
import com.p12.toitdesaines.DTO.MedecinTraitantDTO;
import com.p12.toitdesaines.entity.Adresse;
import com.p12.toitdesaines.entity.Intervenant;
import com.p12.toitdesaines.entity.MedecinTraitant;
import com.p12.toitdesaines.mapper.MedecinTraitantMapper;
import com.p12.toitdesaines.services.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MedecinServiceImpl implements MedecinService {
    @Autowired
    MedecinTraitantRepository medecinTraitantRepository;
    @Autowired
    MedecinTraitantMapper medecinTraitantMapper;
    @Override
    public List<MedecinTraitant> getAll() {
        return medecinTraitantRepository.findAll();
    }

    @Override
    public MedecinTraitant createMedic(MedecinTraitantDTO medecinTraitantDTO) {

        MedecinTraitant medic = medecinTraitantMapper.toDto(medecinTraitantDTO);
        return medecinTraitantRepository.save(medic);
    }

    @Override
    public MedecinTraitant getMedic(Long id) {
        return medecinTraitantRepository.getOne(id);
    }

    @Override
    public void deleteMedic(Long id) {
     medecinTraitantRepository.deleteById(id);
    }


}
