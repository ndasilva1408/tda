package com.p12.toitdesaines.controller;

import com.p12.toitdesaines.entity.Simapa;
import com.p12.toitdesaines.services.SimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MainController {

    @Autowired
    private SimService simService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/calculAPA")
    public ResponseEntity<Simapa> estimationAPA(@RequestBody Simapa simapa) {
      Simapa simapa1 = simService.getValue(simapa);
      if(simapa1 == null) return ResponseEntity.noContent().build();
      return  new ResponseEntity<>(simapa1, HttpStatus.OK);
    }
}
