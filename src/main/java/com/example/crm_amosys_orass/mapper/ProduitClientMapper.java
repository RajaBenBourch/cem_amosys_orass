package com.example.crm_amosys_orass.mapper;

import com.example.crm_amosys_orass.dto.ProduitClientDTO;
import com.example.crm_amosys_orass.model.ProduitClientEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProduitClientMapper extends BaseMapper<ProduitClientEntity, ProduitClientDTO>{
    public ProduitClientMapper(ProduitClientEntity produitClient,   ProduitClientDTO produitClientDto) {
        super(produitClient, produitClientDto);
    }

    public List<ProduitClientDTO> ToProduitClientDtos(List<ProduitClientEntity> produitsclients) {
        List<ProduitClientDTO> dtos = new ArrayList<>();
        for (ProduitClientEntity produitclint: produitsclients) {
            ProduitClientDTO dto = toProduitClientDto(produitclint);
            dtos.add(dto);
        }
        return dtos;
    }
    public ProduitClientEntity toProduitClient(ProduitClientDTO produitClientDto){



        ProduitClientEntity produitClient = toEntity(produitClientDto);
        return produitClient;
    }


    public ProduitClientDTO toProduitClientDto(ProduitClientEntity produitClient){
        ProduitClientDTO produitClientDto =  new ProduitClientDTO();
        produitClientDto.setPrixAchatProduit(produitClient.getPrixAchatProduit());
        produitClientDto.setDateAchatP(produitClient.getDateAchatP());

          return produitClientDto;
    }


}
