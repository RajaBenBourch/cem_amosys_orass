package com.example.crm_amosys_orass.mapper;
import com.example.crm_amosys_orass.dto.ProduitDTO;
import com.example.crm_amosys_orass.model.ProduitEntity;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class ProduitMapper extends BaseMapper<ProduitEntity, ProduitDTO> {
    public ProduitMapper(ProduitEntity produit, ProduitDTO produitDto) {
        super(produit, produitDto);
    }
    public List<ProduitDTO> ToProduitDtos(List<ProduitEntity> produits) {
        List<ProduitDTO> dtos = new ArrayList<>();
        for (ProduitEntity produit: produits) {
            ProduitDTO dto = toProduitDTO(produit);
            dtos.add(dto);
        }
        return dtos;
    }
    public static ProduitDTO toProduitDTO(ProduitEntity produit){
        ProduitDTO produitDto =new ProduitDTO();
        produitDto.setId(produit.getId());
        produitDto.setChefProduit(produit.getChefProduit());
        produitDto.setRef(produit.getRef());
        produitDto.setStatu(produit.getStatu());
        produitDto.setName(produit.getName());
        produitDto.setLibelle(produit.getLibelle());
        produitDto.setDescription(produit.getDescription());
        return produitDto;
    }
    public ProduitEntity toProduit(ProduitDTO produitDTO){
        //ProduitEntity produit = new ProduitEntity();
       // produit.setChefProduit(produitDTO.getChefProduit());
        //produit.setName(produitDTO.getName());
        ProduitEntity produit= toEntity(produitDTO);
        return produit;
    }

}
