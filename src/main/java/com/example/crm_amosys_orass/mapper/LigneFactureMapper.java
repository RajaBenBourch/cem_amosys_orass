package com.example.crm_amosys_orass.mapper;

import com.example.crm_amosys_orass.dto.LigneFactureDTO;
import com.example.crm_amosys_orass.model.LigneFactureEntity;
import com.example.crm_amosys_orass.model.ProduitEntity;
import com.example.crm_amosys_orass.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LigneFactureMapper {

    private ProduitRepository produitRepository;
    public LigneFactureEntity toEntity(LigneFactureDTO ligneFactureDto) {
        LigneFactureEntity ligneFactureEntity = new LigneFactureEntity();
        ligneFactureEntity.setProduit(getProduct(ligneFactureDto.getRefProduit()));
        ligneFactureEntity.setQuantite(ligneFactureDto.getQuantite());
        return ligneFactureEntity;
    }

    public LigneFactureDTO toDto(LigneFactureEntity ligneFactureEntity) {
        LigneFactureDTO ligneFactureDto = new LigneFactureDTO();
        ligneFactureDto.setRefProduit(ligneFactureEntity.getProduit().getRef());
        ligneFactureDto.setQuantite((int) ligneFactureEntity.getQuantite());
        return ligneFactureDto;
    }

    public List<LigneFactureEntity> toEntities(List<LigneFactureDTO> ligneFactureDtoList) {
        return ligneFactureDtoList.stream().map(this::toEntity).toList();
    }

    public List<LigneFactureDTO> toDto(List<LigneFactureEntity> ligneFactureDtoList) {
        return ligneFactureDtoList.stream().map(this::toDto).toList();
    }

    private ProduitEntity getProduct(String refProduit) {
        final  var byRef = produitRepository.findByRef(refProduit);
        if (byRef.isEmpty()) {
            throw new RuntimeException("product not found !!");
        }
        return byRef.get();
    }
}
