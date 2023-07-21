package com.example.crm_amosys_orass.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

@Entity
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "crm_client_produit")
public class ProduitClientEntity {
    @Id
    @GeneratedValue
    private Long idProduitClient;
    private String PrixAchatProduit;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateAchatP;
    @ManyToOne
    @JoinColumn(name="idClient")
    ClientEntity client;
    @ManyToOne
    @JoinColumn(name="id")
    ProduitEntity produit;
}
