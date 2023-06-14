package com.example.crm_amosys_orass.dto;

import com.example.crm_amosys_orass.model.ClientEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Data
@Component
public class ProduitDTO {
    private Long id;
    private Long idOpportunity;
    private Long idClient;

    private String ref;
    private String libelle;

    private Long idDocument;
    private String 	Description;

    private String name;
    private String chefProduit;
    private String statu;
    private Date dateAchatP;

    private String PrixAchatProduit;


}