package com.example.crm_amosys_orass.dto;

import com.example.crm_amosys_orass.model.ClientEntity;
import com.example.crm_amosys_orass.model.EtapeEntity;
import com.example.crm_amosys_orass.model.ProduitEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OpportunityDTO {
    private Long idOpportunity;
    private  long idEtape;
    private Long idUser;
    private String User;
    private Long idClient;

    private String Etape;
    private List<EtapeDTO> etapes;
    private String name;
    //private String stage;
    private LocalDate closeDate;
    private String Statu;
    private String produitsConcat;
    private String produits;
    private Long idproduit;

    // other fields
    private String concatenatedProducts;
    private String client;
    public String getClient() {
        return client;
    }
    public void setClient(String cliente) {
        this.client = cliente;
    }
    // getters and setters
    public String getConcatenatedProducts() {
        return concatenatedProducts;
    }

    public void setConcatenatedProducts(String concatenatedProducts) {
        this.concatenatedProducts = concatenatedProducts;
    }


}
