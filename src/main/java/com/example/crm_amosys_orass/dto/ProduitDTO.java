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

    @NotBlank
    private String ref;
    @NotBlank
    private String libelle;
    @NotNull
    private BigDecimal prix;
    @NotNull
    private long quantiteStock;

}
