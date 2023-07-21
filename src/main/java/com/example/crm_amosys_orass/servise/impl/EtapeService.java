package com.example.crm_amosys_orass.servise.impl;


import com.example.crm_amosys_orass.dto.ClientDTO;
import com.example.crm_amosys_orass.dto.ContactDTO;
import com.example.crm_amosys_orass.dto.EtapeDTO;
import com.example.crm_amosys_orass.dto.OpportunityDTO;
import com.example.crm_amosys_orass.mapper.EtapeMapper;

import com.example.crm_amosys_orass.mapper.OpportunityMapper;

import com.example.crm_amosys_orass.model.EtapeEntity;
import com.example.crm_amosys_orass.model.OpportuniteEntity;
import com.example.crm_amosys_orass.repository.EtapeRepository;
import com.example.crm_amosys_orass.repository.OpportunityRepository;
import com.example.crm_amosys_orass.utils.IGenericMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EtapeService {

    @Autowired
    private EtapeRepository etapeRepository;

    @Autowired
    private IGenericMapper iGenericMapper;
    @Autowired
    private OpportunityMapper opportunityMapper;
    @Autowired
    private EtapeMapper etapeMapper;
    @Autowired
    private OpportunityRepository opportunityRepository;

    @Autowired
    public void EtapeOpportuniteService(EtapeRepository etapeRepository, EtapeMapper etapeMapper) {
        this.etapeRepository = etapeRepository;
        this.etapeMapper = etapeMapper;
    }
  /*  public EtapeDTO createEtape(EtapeDTO dto) {
        EtapeEntity entity = etapeMapper.toEntity(dto);
        entity = etapeRepository.save(entity);
        return etapeMapper.toEtapDto(entity);
    }*/


    public EtapeDTO createEtape(EtapeDTO dto) {
        try {
            EtapeEntity entity = etapeMapper.toEntity(dto);
            entity = etapeRepository.save(entity);
            return etapeMapper.toEtapDto(entity);
        } catch (Exception e) {
            e.printStackTrace();
            throw e; // or handle the exception as needed
        }
    }


    public EtapeDTO getEtapeById(Long id) {
        Optional<EtapeEntity> etapeOptional = etapeRepository.findById(id);
        return etapeOptional.map(etapeMapper::toEtapDto).orElse(null);
    }

    public EtapeDTO updateEtape(EtapeDTO etapeDTO){
        Optional<EtapeEntity> emp = this.etapeRepository.findById(etapeDTO.getIdEtape());
        if (emp.isEmpty()){
            throw new ResourceNotFoundException("Etape not found for this id ");
        }

        return iGenericMapper.map(etapeRepository.save(iGenericMapper.map(etapeDTO, EtapeEntity.class)),EtapeDTO.class);
    }
    public boolean deleteEtapeOpportunite(Long idEtape) {
        Optional<EtapeEntity> etapeOptional = etapeRepository.findById(idEtape);
        if (etapeOptional.isPresent()) {
            etapeRepository.delete(etapeOptional.get());
            return true;
        }
        return false;
    }

   /* public  List<EtapeDTO> getAllEtapes() {
        List<EtapeEntity> etapesOpportunite = etapeRepository.findAll();
        return etapesOpportunite.stream()
                .map(etapeMapper::toEtapDto)
                .collect(Collectors.toList());
    }*/
  public  List<EtapeDTO>getAll() {
        List<EtapeEntity> etapeEntities = etapeRepository.findAll();
        return etapeMapper.ToEtapDtos(etapeEntities);
    }


///////////////////////////////////////////////
    public List<OpportunityDTO> getOpportunite(long idEtape) {
        Optional<EtapeEntity> etape = etapeRepository.findById(idEtape);
        List<OpportuniteEntity> opportunites = etape.get().getOpportunite();
       // List<OpportuniteEntity> opportunites1 = etape.get().getOpportunite();
        return opportunityMapper.ToOpportuniteDtos(opportunites);
    }
    public List<OpportunityDTO>  deleteoppurtunite(long idOpportunity){
        OpportuniteEntity opportunite = opportunityRepository.findById(idOpportunity).get();
        opportunityRepository.deleteById(idOpportunity);
        return getOpportunite(opportunite.getEtape().getIdEtape());
    }
    public void mergeOpp(OpportunityDTO opportunityDTO) {
        EtapeEntity etape = etapeRepository.findById(opportunityDTO.getIdEtape()).get();
        OpportuniteEntity opportunite = opportunityMapper.toEntity(opportunityDTO);
        opportunite.setEtape(etape);
        opportunite = opportunityRepository.save(opportunite);
        List<OpportuniteEntity> opportuniteEntities = etape.getOpportunite();
        opportuniteEntities.add(opportunite);
        etape.setOpportunite(opportuniteEntities);
        etapeRepository.save(etape);
    }
    ////////////////////
}
