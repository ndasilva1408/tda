package com.p12.toitdesaines.controller;

import com.p12.toitdesaines.DTO.ClientDTO;
import com.p12.toitdesaines.entity.Client;
import com.p12.toitdesaines.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping(value ="/saveClient")
    public ResponseEntity<Client> createClient(@RequestBody ClientDTO clientDTO) {
       Client client =  clientService.createClient(clientDTO);
       if(client == null) return ResponseEntity.noContent().build();
       return new ResponseEntity<>(client,HttpStatus.CREATED);
    }

    @GetMapping(value = "/getClients")
    public ResponseEntity<List<Client>> getClients(){
        List<Client> clientList = clientService.getClients();
        if(clientList == null) return  ResponseEntity.noContent().build();
        return  new ResponseEntity<>(clientList,HttpStatus.OK);
    }



    @DeleteMapping(value = "/deleteClient")
    public ResponseEntity<Void> deleteClient(@RequestParam(name = "id",defaultValue = "")Long id){
        Client client = clientService.getClient(id);
        if(client==null) return ResponseEntity .noContent().build();
        clientService.deleteClient(client.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
