package com.example.crm_amosys_orass.servise.impl;
import com.example.crm_amosys_orass.dto.ClientDTO;
import com.example.crm_amosys_orass.dto.ContactDTO;
import com.example.crm_amosys_orass.dto.EtapeDTO;
import com.example.crm_amosys_orass.dto.OpportunityDTO;
import com.example.crm_amosys_orass.mapper.EtapeMapper;
import com.example.crm_amosys_orass.mapper.OpportunityMapper;
import com.example.crm_amosys_orass.model.*;
import com.example.crm_amosys_orass.repository.EtapeRepository;
import com.example.crm_amosys_orass.repository.OpportunityRepository;
import com.example.crm_amosys_orass.repository.UserRepository;
import com.example.crm_amosys_orass.utils.IGenericMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OpportunityService {

    @Autowired
    private OpportunityRepository opportunityRepository;

    @Autowired
    private UserRepository accountRepository;
    @Autowired
    private OpportunityMapper opportunityMapper;
    @Autowired
    private IGenericMapper iGenericMapper;
    @Autowired
    private EtapeMapper etapeMapper;

    @Autowired
    private EtapeService etapeService;

    @Autowired
    private EtapeRepository etapeRepository;
    public OpportunityDTO createOpportunity(OpportunityDTO opportunityDto) {
        OpportuniteEntity opportunity = opportunityMapper.toEntity(opportunityDto);
        UserEntity user = (UserEntity) accountRepository.findById(opportunityDto.getIdUser())
                .orElseThrow(() -> new EntityNotFoundException("Account not found with id: " + opportunityDto.getIdUser()));

        opportunity.setUser(user);
        OpportuniteEntity savedOpportunity = opportunityRepository.save(opportunity);
        return opportunityMapper.toDto(savedOpportunity);
    }

    public  OpportunityDTO addEtapes(OpportuniteEntity opportunity){
        OpportunityDTO opportunityDTO = opportunityMapper.toDto(opportunity);
       //opportunityDTO.setEtapes(getEtape(opportunityDTO.getIdOpportunity()).toString());
        opportunityDTO.setEtapes(getEtape(opportunityDTO.getIdOpportunity()));
        return opportunityDTO;
    }
    public List<OpportunityDTO> getAllOpportunities() {
        List<OpportuniteEntity> opportunities = opportunityRepository.findAll(Sort.by(Sort.Direction.ASC, "idOpportunity"));
        List<OpportunityDTO> opportunityDTOS = new ArrayList<>();
        for (OpportuniteEntity oppor: opportunities) {
            opportunityDTOS.add(addEtapes(oppor));
        }
       /* List<OpportunityDTO> opportunityDTOS = opportunities.stream()
                .map(this::addEtapes)
                .collect(Collectors.toList());*/
        return opportunityDTOS;
    }

    public OpportunityDTO getOpportunityById(Long idO) {
        OpportuniteEntity opportunity = opportunityRepository.findById(idO)
                .orElseThrow(() -> new EntityNotFoundException("Opportunity not found with id: " + idO));
        return opportunityMapper.toDto(opportunity);
    }




   /* public OpportunityDTO update(OpportunityDTO opportunityDTO){
        Optional<OpportuniteEntity> emp = this.opportunityRepository.findById(opportunityDTO.getIdOpportunity());
        if (emp.isEmpty()){
            throw new ResourceNotFoundException("Opportunite not found ");
        }

        return iGenericMapper.map(opportunityRepository.save(iGenericMapper.map(opportunityDTO, OpportuniteEntity.class)),OpportunityDTO.class);
    }
    */
    public OpportunityDTO updateOpportunity(Long id, OpportunityDTO opportunityDto) {
        OpportuniteEntity existingOpportunity = opportunityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Opportunity not found with id: " + id));

        OpportuniteEntity updatedOpportunity = opportunityMapper.toEntity(opportunityDto);
        updatedOpportunity.setIdOpportunity(existingOpportunity.getIdOpportunity());

        UserEntity user = (UserEntity) accountRepository.findById(opportunityDto.getIdUser())
                .orElseThrow(() -> new EntityNotFoundException("Account not found with id: " + opportunityDto.getIdUser()));
        updatedOpportunity.setUser(user);

        OpportuniteEntity savedOpportunity = opportunityRepository.save(updatedOpportunity);
        return opportunityMapper.toDto(savedOpportunity);
    }





       /*
    public List<OpportunityDTO>  deleteOpportunityById(long idOpportunity){
            OpportuniteEntity opportunite = opportunityRepository.findById(idOpportunity).get();
            opportunityRepository.deleteById(idOpportunity);
            return (List<OpportunityDTO>) getOpportunity((opportunite.getIdOpportunity()));

        }*/
       public void  delete(Long idOpportunity){
           this.opportunityRepository.deleteById(idOpportunity);
       }



    public OpportuniteEntity getOpportunity(Long opportunityId) {
        return opportunityRepository.findById(opportunityId)
                .orElseThrow(() -> new NoSuchElementException("Opportunity not found with ID: " + opportunityId));
    }
    public List<EtapeDTO> getEtape(long idOpportunity) {
        Optional<OpportuniteEntity> opportunite = opportunityRepository.findById(idOpportunity);
        List<EtapeDTO> etaps = etapeService.getAll();
        return construitEtape(etaps, opportunite.get().getEtape());
    }
    //apre avoir un workflow, actualiment the opputunity peut allez un etap avant et un arrier
    public List<EtapeDTO> construitEtape(List<EtapeDTO> etapeDTOS, EtapeEntity etape) {
        List<EtapeDTO> result = new ArrayList<>();
        for(int i=0; i<etapeDTOS.size(); i++){
            if(etapeDTOS.get(i).getIdEtape() == etape.getIdEtape()){
                if(i == 0 && etapeDTOS.size() != 1){
                    result.add(etapeDTOS.get(i+1));
                } else if (i != 0 && i == etapeDTOS.size() - 1) {
                    result.add(etapeDTOS.get(i-1));
                } else if(etapeDTOS.size() == 1){

                }else {
                    result.add(etapeDTOS.get(i-1));
                    result.add(etapeDTOS.get(i+1));
                }
            }
        }
        return result;
    }



 public void save(OpportunityDTO opportunityDTO){
        EtapeEntity etape = etapeRepository.findById(opportunityDTO.getIdEtape()).get();
        if(etape == null){
        } else{
            OpportuniteEntity opportunite =opportunityRepository.findById(opportunityDTO.getIdOpportunity()).get();

            opportunite.setEtape(etape);

            opportunityRepository.save(opportunite);
        }

    }
    public List<OpportunityDTO>getAll(){
        List<OpportuniteEntity> opportunites = opportunityRepository.findAll(Sort.by(Sort.Direction.ASC, "idOpportunity"));
        return opportunityMapper.ToOpportuniteDtos(opportunites);
    }

}