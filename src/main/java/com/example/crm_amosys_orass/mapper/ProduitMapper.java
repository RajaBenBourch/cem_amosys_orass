package com.example.crm_amosys_orass.mapper;

import com.example.crm_amosys_orass.dto.ClientDTO;
import com.example.crm_amosys_orass.dto.ProduitDTO;
import com.example.crm_amosys_orass.model.ClientEntity;
import com.example.crm_amosys_orass.model.ProduitEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProduitMapper extends BaseMapper<ProduitEntity, ProduitDTO> {
    public ProduitMapper(ProduitEntity produit, ProduitDTO produitDto) {
        super(produit, produitDto);
    }

    public List<ProduitDTO> toProduitDtos(List<ProduitEntity> produits) {
        List<ProduitDTO> dtos = new ArrayList<>();
        for (ProduitEntity produit: produits) {
            ProduitDTO dto = toProduitDTO(produit);
            dtos.add(dto);
        }
        return dtos;
    }

    public ProduitDTO toProduitDTO(ProduitEntity produit){
        ProduitDTO produitDto = toDTO(produit);
        return produitDto;
    }

    public ProduitEntity toProduit(ProduitDTO produitDto){
        ProduitEntity produit = toEntity(produitDto);
        return produit;
    }


}
