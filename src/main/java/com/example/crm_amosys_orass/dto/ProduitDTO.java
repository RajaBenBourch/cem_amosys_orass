package com.example.crm_amosys_orass.dto;

import com.example.crm_amosys_orass.model.ClientEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
@Data
@Component
public class ProduitDTO {
    private Integer id;
    @NotBlank
    private String ref;
    @NotBlank
    private String libelle;
    @NotBlank
    private BigDecimal prix;
    @NotNull
    private long quantiteStock;
    @NotBlank
    private String name;
    @NotBlank
    private String chefProduit;
    @NotBlank
    private String statu;



}