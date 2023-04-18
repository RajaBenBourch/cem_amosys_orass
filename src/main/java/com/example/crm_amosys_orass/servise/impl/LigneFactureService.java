package com.example.crm_amosys_orass.servise.impl;

import com.example.crm_amosys_orass.model.LigneFactureEntity;
import com.example.crm_amosys_orass.repository.LigneFactureRepository;

import java.util.List;

public class LigneFactureService {
    private  LigneFactureRepository ligneFactureRepository;


    public LigneFactureEntity save(LigneFactureEntity ligneFactureEntity) {
        return ligneFactureRepository.save(ligneFactureEntity);
    }


    public List<LigneFactureEntity> findAll() {
        return ligneFactureRepository.findAll();
    }
}
