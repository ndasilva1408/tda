package com.p12.toitdesaines.services.impl;

import com.p12.toitdesaines.DAO.AdresseRepository;
import com.p12.toitdesaines.DAO.IntervenantRepository;
import com.p12.toitdesaines.DTO.AdresseDTO;
import com.p12.toitdesaines.DTO.IntervenantDTO;
import com.p12.toitdesaines.entity.Adresse;
import com.p12.toitdesaines.entity.Client;
import com.p12.toitdesaines.entity.Intervenant;
import com.p12.toitdesaines.mapper.AdresseMapper;
import com.p12.toitdesaines.mapper.IntervenantMapper;
import com.p12.toitdesaines.services.IntervenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntervenantServiceImpl implements IntervenantService {
    @Autowired
    IntervenantRepository intervenantRepository;
    @Autowired
    IntervenantMapper intervenantMapper;
    @Autowired
    AdresseRepository adresseRepository;
    @Autowired
    AdresseMapper adresseMapper;

    @Override
    public List<Intervenant> getInters() {
        return intervenantRepository.findAll();
    }

    @Override
    public Intervenant getInter(Long id) {
        return intervenantRepository.getOne(id);
    }

    @Override
    public void deleteInter(Long id) {
        intervenantRepository.deleteById(id);

    }

    @Override
    public Intervenant createInters(IntervenantDTO intervenantDTO) {
        Adresse adresse = adresseRepository.getOne((long) 0);
        AdresseDTO adresseDTO = adresseMapper.toAdresse(adresse);
        intervenantDTO.setAdresse(adresseDTO);
        Intervenant intervenant = intervenantMapper.toDto(intervenantDTO);

        return intervenantRepository.save(intervenant);
    }
}
