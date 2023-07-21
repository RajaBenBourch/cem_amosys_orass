package com.example.crm_amosys_orass.servise.impl;
import com.example.crm_amosys_orass.controller.ClientController;
import com.example.crm_amosys_orass.dto.ClientDTO;
import com.example.crm_amosys_orass.dto.ContactDTO;
import com.example.crm_amosys_orass.dto.ProduitClientDTO;
import com.example.crm_amosys_orass.dto.ProduitDTO;
import com.example.crm_amosys_orass.mapper.ProduitClientMapper;
import com.example.crm_amosys_orass.model.ClientEntity;
import com.example.crm_amosys_orass.model.ContactEntity;
import com.example.crm_amosys_orass.model.ProduitClientEntity;
import com.example.crm_amosys_orass.repository.ClientRepository;
import com.example.crm_amosys_orass.repository.ProduitClientRepository;
import com.example.crm_amosys_orass.repository.ProduitRepository;
import com.example.crm_amosys_orass.utils.IGenericMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProduitClientService {
    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientController clientController;
    @Autowired
    private ProduitClientRepository produitClientRepository;
    @Autowired
    private ProduitClientMapper produitClientMapper ;
    @Autowired
    private IGenericMapper iGenericMapper;

    public List<ProduitDTO> deleteProduitClient(long idProduitClient){
        ProduitClientEntity produitClient = produitClientRepository.findById(idProduitClient).get();
        produitClientRepository.deleteById(idProduitClient);
        return clientController.getproduitByClient(produitClient.getClient().getIdClient());
    }


    public List<ProduitDTO> update(ProduitClientDTO produitClient){
        ProduitClientEntity p = produitClientMapper.toProduitClient(produitClient);
        p.setClient(clientRepository.findById(produitClient.getIdClient()).get());
        p.setProduit(produitRepository.findById(produitClient.getId()).get());
        produitClientRepository.save(produitClientMapper.toProduitClient(produitClient));
        return clientController.getproduitByClient(produitClient.getIdClient());
    }

}
