package com.example.crm_amosys_orass.mapper;

import com.example.crm_amosys_orass.dto.FactureDTO;
import com.example.crm_amosys_orass.model.ClientEntity;
import com.example.crm_amosys_orass.model.FactureEntity;
import com.example.crm_amosys_orass.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class FactureMapper {
    private  ClientRepository clientRepository;
    private  LigneFactureMapper ligneFactureMapper;


    public FactureDTO toDto(FactureEntity factureEntity) {
        FactureDTO factureDto = new FactureDTO();
        factureDto.setRef(factureEntity.getRef());
        factureDto.setCodeClient(factureEntity.getClient().getCodeClient());
        factureDto.setLigneFactureDtoList(ligneFactureMapper.toDto(factureEntity.getLigneFactures()));
        return factureDto;
    }

    public FactureEntity toEntity(FactureDTO factureDto) {
        FactureEntity factureEntity = new FactureEntity();
        factureEntity.setRef(factureDto.getRef());
        factureEntity.setClient(getClient(factureDto.getCodeClient()));
        factureEntity.setLigneFactures(ligneFactureMapper.toEntities(factureDto.getLigneFactureDtoList()));
        return factureEntity;

    }

    public List<FactureDTO> toDto(List<FactureEntity> facturesEntity) {
        return facturesEntity.stream().map(this::toDto).toList();
    }

    public List<FactureEntity> toEntities(List<FactureDTO> factureDtos) {
        return factureDtos.stream().map(this::toEntity).toList();
    }

    private ClientEntity getClient(String code_Client) {
        final var byCodeClient = clientRepository.findByCodeClient(code_Client);
        if (byCodeClient.isEmpty()) {
            throw new RuntimeException("Client not found");
        }
        return byCodeClient.get();
    }
}
