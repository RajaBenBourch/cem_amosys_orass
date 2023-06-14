package com.example.crm_amosys_orass.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "crm_Opportuniter_produit")
public class ProduitOpportuniterEntity {
    @Id
    @GeneratedValue
    private Long idOppClient;
    @ManyToOne
    @JoinColumn(name="idOpportuniter")
    OpportuniteEntity opportunite;
    @ManyToOne
    @JoinColumn(name="id")
    ProduitEntity produit;
}
