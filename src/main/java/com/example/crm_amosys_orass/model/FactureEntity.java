package com.example.crm_amosys_orass.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "factures")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class FactureEntity {


    /**
     *
     */
    private static final long serialVersionUID = -4612504723628291981L;

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String ref;

    @Column(nullable = false,name = "date_creation_facture")
    private Date date;


    @ManyToOne
    private ClientEntity client;

    @OneToMany(mappedBy = "facture",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<LigneFactureEntity> ligneFactures;



}