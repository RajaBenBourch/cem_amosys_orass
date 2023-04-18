package com.example.crm_amosys_orass.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable

public class LigneFactureKey {

    private static final long serialVersionUID = 4722352116317893282L;


    @Column(name="facture_id")
    private Integer factureId;

    @Column(name="produit_id")
    private Integer produitId;
}
