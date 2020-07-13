package com.p12.toitdesaines.services.impl;

import com.p12.toitdesaines.DAO.ClientRepository;
import com.p12.toitdesaines.DTO.ClientDTO;
import com.p12.toitdesaines.entity.Client;
import com.p12.toitdesaines.entity.ClientLobs;
import com.p12.toitdesaines.mapper.ClientMapper;
import com.p12.toitdesaines.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ClientMapper clientMapper;

    @Override
    public List<Client> getClients() {
        return clientRepository.findThem();
    }

   @Override
    public Client getClient(Long id) {
        return clientRepository.getOne(id);
    }

    @Override
    public Client createClient(ClientDTO clientDTO) {
        clientDTO.setEn_attente(true);
        clientDTO.setDroitImg(false);
        Client client = clientMapper.toDto(clientDTO);

        return clientRepository.save(client) ;
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    }

