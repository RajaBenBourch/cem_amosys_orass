package com.example.crm_amosys_orass.mapper;
import com.example.crm_amosys_orass.dto.ClientDTO;
import com.example.crm_amosys_orass.dto.EtapeDTO;
import com.example.crm_amosys_orass.dto.OpportunityDTO;
import com.example.crm_amosys_orass.model.*;
import com.example.crm_amosys_orass.servise.impl.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Component
public class OpportunityMapper extends BaseMapper<EtapeEntity, EtapeDTO> {

    public OpportunityMapper(EtapeEntity etapeEntity, EtapeDTO etapeDTO) {
        super(etapeEntity, etapeDTO);
    }

    public List<OpportunityDTO> ToOpportuniteDtos(List<OpportuniteEntity> opportunites) {
        List<OpportunityDTO> dtos = new ArrayList<>();
        for (OpportuniteEntity opportunite: opportunites) {
            OpportunityDTO dto = toDto(opportunite);
            dtos.add(dto);
        }
        return dtos;
    }
    public  OpportunityDTO toDto(OpportuniteEntity opportunity) {
        String produitConcat= "";

        OpportunityDTO dto = new OpportunityDTO();
        for(ProduitOpportuniterEntity produitOpportuniter: opportunity.getProduits()) {
            ProduitEntity produit = produitOpportuniter.getProduit();
            produitConcat += produit.getLibelle() + " ";
        }

        dto.setProduitsConcat(produitConcat);
        dto.setIdOpportunity(opportunity.getIdOpportunity());
        dto.setName(opportunity.getName());
        dto.setCloseDate(opportunity.getCloseDate());
        dto.setStatu(opportunity.getStatu());
        dto.setIdUser(opportunity.getUser().getIdUser());
       dto.setClient(opportunity.getClient().getEntreprisePrincipal());

       dto.setEtape(opportunity.getEtape().getName());

       // dto.setEtape(Collections.singletonList(opportunity.getEtape().getName()));
        return dto;
    }
    public OpportuniteEntity toEntity(OpportunityDTO dto) {
        OpportuniteEntity opportunity = new OpportuniteEntity();
        opportunity.setIdOpportunity(dto.getIdOpportunity());
        opportunity.setName(dto.getName());
        opportunity.setCloseDate(dto.getCloseDate());
        opportunity.setStatu(dto.getStatu());
        //opportunity.setUser(dto.getUser());
        return opportunity;

    }

}