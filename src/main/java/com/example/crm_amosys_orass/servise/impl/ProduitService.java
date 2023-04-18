package com.example.crm_amosys_orass.servise.impl;


import com.example.crm_amosys_orass.dto.ClientDTO;
import com.example.crm_amosys_orass.dto.ProduitDTO;
import com.example.crm_amosys_orass.mapper.ProduitMapper;
import com.example.crm_amosys_orass.model.ClientEntity;
import com.example.crm_amosys_orass.model.FactureEntity;
import com.example.crm_amosys_orass.model.ProduitEntity;
import com.example.crm_amosys_orass.repository.ProduitRepository;
import com.example.crm_amosys_orass.utils.IGenericMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProduitService{    /************/
@Autowired
    private ProduitRepository produitRepository;

@Autowired
    private ProduitMapper produitMapper;

@Autowired
private IGenericMapper iGenericMapper;

    public ProduitDTO save(ProduitDTO produitDto) {
        if (findByRef(produitDto.getRef()) != null) return null;
        ProduitEntity produitEntity = iGenericMapper.map(produitDto, ProduitEntity.class);
        ProduitEntity savedProduit = produitRepository.save(produitEntity);
        return iGenericMapper.map(savedProduit, ProduitDTO.class);
    }

    @Transactional

    public int delete(String ref) {
        return produitRepository.deleteByRef(ref);
    }


    public ProduitDTO update(ProduitDTO produitDto) {
        Optional<ProduitEntity> produitEntity = produitRepository.findByRef(produitDto.getRef());
        if (produitEntity.isEmpty()) return null;
        update(produitEntity.get(), produitDto);
        ProduitEntity saved = produitRepository.save(produitEntity.get());
        return iGenericMapper.map(saved, ProduitDTO.class);
    }

    private void update(ProduitEntity produitEntity, ProduitDTO produitDto) {
        produitEntity.setLibelle(produitDto.getLibelle());
        produitEntity.setPrix(produitDto.getPrix());
        produitEntity.setQuantiteStock(produitDto.getQuantiteStock());
    }


    public ProduitDTO findByRef(String ref) {
        ProduitEntity produitEntity = produitRepository.findByRef(ref).orElse(null);
        if (produitEntity == null) return null;
        return iGenericMapper.map(produitEntity, ProduitDTO.class);
    }


    public List<ProduitDTO> findAll() {
        return produitMapper.toProduitDtos(produitRepository.findAll());
    }



}