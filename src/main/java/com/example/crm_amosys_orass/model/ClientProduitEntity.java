package com.example.crm_amosys_orass.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Date;
@Entity
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientProduitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idProduit")
    private ProduitEntity produit;

    @ManyToOne
    @JoinColumn(name = "idClient")
    private ClientEntity client;

    @NotNull(message = "Ce champ est obligatoire !")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateAchatP;
}
