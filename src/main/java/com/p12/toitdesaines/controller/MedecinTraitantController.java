package com.p12.toitdesaines.controller;

import com.p12.toitdesaines.DTO.IntervenantDTO;
import com.p12.toitdesaines.DTO.MedecinTraitantDTO;
import com.p12.toitdesaines.entity.Employee;
import com.p12.toitdesaines.entity.Intervenant;
import com.p12.toitdesaines.entity.MedecinTraitant;
import com.p12.toitdesaines.services.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MedecinTraitantController {

    @Autowired
    MedecinService medecinService;


    @GetMapping(value = "/getMedecins")
    public ResponseEntity<List<MedecinTraitant>> getMedecins(){
        List<MedecinTraitant> medecinTraitantList = medecinService.getAll();
        if(medecinTraitantList == null) return  ResponseEntity.noContent().build();
        return  new ResponseEntity<>(medecinTraitantList, HttpStatus.OK);
    }

    @PostMapping(value = "/newMedic")
    public ResponseEntity<MedecinTraitant> createMedic(@RequestBody MedecinTraitantDTO medecinTraitantDTO) {
        MedecinTraitant newMedic = medecinService.createMedic(medecinTraitantDTO);
        return new ResponseEntity<>(newMedic, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteMedic")
    public ResponseEntity<Void> deleteMedic(@RequestParam(name = "id",defaultValue = "")Long id){
        MedecinTraitant medecinTraitant = medecinService.getMedic(id);
        if(medecinTraitant==null) return ResponseEntity .noContent().build();
        medecinService.deleteMedic(medecinTraitant.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

