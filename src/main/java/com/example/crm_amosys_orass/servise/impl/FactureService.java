package com.example.crm_amosys_orass.servise.impl;

import com.example.crm_amosys_orass.model.FactureEntity;
import com.example.crm_amosys_orass.repository.FactureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class FactureService {

    private FactureRepository factureRepository;


    public FactureEntity save(FactureEntity factureEntity) {
        return factureRepository.save(factureEntity);
    }


    public List<FactureEntity> findAll() {
        return factureRepository.findAll();
    }
}
