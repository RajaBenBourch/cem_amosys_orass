package com.example.crm_amosys_orass.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProduitClientDTO {
    private Long idProduitClient;

    private Long idClient;

    private Long id;
    private String PrixAchatProduit;
    private Date dateAchatP;
    //private  byte[] list;
}
