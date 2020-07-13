package com.p12.toitdesaines.controller;

import com.p12.toitdesaines.DTO.EmployeeDTO;
import com.p12.toitdesaines.DTO.IntervenantDTO;
import com.p12.toitdesaines.entity.Employee;
import com.p12.toitdesaines.entity.Intervenant;
import com.p12.toitdesaines.services.IntervenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class IntervenantController {
    @Autowired
    IntervenantService intervenantService;



    @PostMapping(value = "/newInter")
    public ResponseEntity<Intervenant> createIntervenants(@RequestBody IntervenantDTO intervenantDTO) {
        Intervenant newInter = intervenantService.createInters(intervenantDTO);
        return new ResponseEntity<>(newInter, HttpStatus.OK);
    }

    @GetMapping(value = "/getInters")
    public ResponseEntity<List<Intervenant>> getInters(){
        List<Intervenant> intervenantList = intervenantService.getInters();
        if(intervenantList == null) return  ResponseEntity.noContent().build();
        return  new ResponseEntity<>(intervenantList, HttpStatus.OK);
    }


    @DeleteMapping(value = "/deleteInter")
    public ResponseEntity<Void> deleteEmployee(@RequestParam(name = "id",defaultValue = "")Long id){
        Intervenant intervenant = intervenantService.getInter(id);
        if(intervenant==null) return ResponseEntity .noContent().build();
        intervenantService.deleteInter(intervenant.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

