package com.example.crm_amosys_orass.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "produits")
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitEntity{

    /**
     *
     */
    private static final long serialVersionUID = -7275079172834495736L;


    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String libelle;


    @Column(nullable=false)
    private String 	ref;


    @Column(nullable = false)
    private BigDecimal prix;


    @Column(nullable = false)
    private double quantiteStock;

    @OneToMany(mappedBy = "produit",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<LigneFactureEntity> ligneFactures;


}