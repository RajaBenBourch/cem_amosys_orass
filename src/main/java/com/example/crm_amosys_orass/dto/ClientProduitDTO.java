package com.example.crm_amosys_orass.dto;

import com.example.crm_amosys_orass.model.ClientEntity;
import com.example.crm_amosys_orass.model.ProduitEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Date;


@Component
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientProduitDTO {

    private Long id;


    private ProduitEntity produit;


    private ClientEntity client;


    private Date dateAchatP;


}
