package com.example.crm_amosys_orass.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "ligne_facture")
@Data
@ToString
public class LigneFactureEntity {


    private static final long serialVersionUID = -3181735183192870271L;


    @EmbeddedId
    private LigneFactureKey id;


    @ManyToOne()
    @MapsId("factureId")
    @JoinColumn(name = "facture_id")
    private FactureEntity facture;


    @ManyToOne()
    @MapsId("produitId")
    @JoinColumn(name = "produit_id")
    private ProduitEntity produit;

    private double quantite;


}