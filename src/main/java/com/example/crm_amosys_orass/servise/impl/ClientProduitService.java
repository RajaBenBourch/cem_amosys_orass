package com.example.crm_amosys_orass.servise.impl;
import com.example.crm_amosys_orass.dto.ClientProduitDTO;
import com.example.crm_amosys_orass.mapper.ClientProduitMapper;
import com.example.crm_amosys_orass.model.ClientProduitEntity;
import com.example.crm_amosys_orass.repository.*;
import com.example.crm_amosys_orass.utils.IGenericMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientProduitService {
    @Autowired
    private ClientProduitRepository clientProduitRepository;

    @Autowired
    private ProduitRepository  produitRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private IGenericMapper iGenericMapper;

    @Autowired
    private ClientProduitMapper clientProduitMapper;

    public ClientProduitDTO getById(Long id) {
        Optional<ClientProduitEntity> emp = this.clientProduitRepository.findById(id);
        if (emp.isEmpty()){
            throw new ResourceNotFoundException("Country not found for this id ");
        }
        return iGenericMapper.map(emp.get(), ClientProduitDTO.class);

    }
    public List<ClientProduitDTO> getAll() {
        List<ClientProduitEntity> clientsproduits = clientProduitRepository.findAll();
        return clientProduitMapper.ToClientProduitDtos(clientsproduits);
    }
    public ClientProduitDTO save(ClientProduitDTO clientProduitDto) {
       // if (findById(clientProduitDto.getId()) != null) return null;
        ClientProduitEntity clientProduitEntity = iGenericMapper.map(clientProduitDto, ClientProduitEntity.class);
        ClientProduitEntity savedProduit = clientProduitRepository.save(clientProduitEntity);
       // return iGenericMapper.map(savedProduit, ProduitDTO.class);

        return iGenericMapper.map(savedProduit, ClientProduitDTO.class);
    }

    }






