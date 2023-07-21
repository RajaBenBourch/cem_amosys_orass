package com.example.crm_amosys_orass.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "crm_produit_information")
public class ProduitEntity{
    @Id
    @GeneratedValue
    private Long id;
    private String libelle;
    private String name;
    private String chefProduit;
    private String statu;
    private String 	ref;
    private String 	Description;
    private Long idclient;
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    //@Temporal(TemporalType.DATE)
   // private Date dateAchatP;
    /*@ManyToOne
    @JoinColumn(name="idClient", nullable=false)
    ClientEntity client;*/
    @OneToMany(mappedBy = "produit")
    private List<ProduitClientEntity> clients;
    private byte[] liste;
    @OneToMany(mappedBy = "produits")
    List<DocumentationEntity> documents;
     @OneToMany(mappedBy = "produit")
     private List<ProduitOpportuniterEntity> opportunites;
  /* @ManyToMany(mappedBy = "products")
   private Set<OpportuniteEntity> opportunities = new HashSet<>();*/

}