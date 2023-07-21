package com.example.crm_amosys_orass.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Entity
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "crm_Ville_Assirance")
public class VilleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long idVille;
    @Column(name ="ville")
    private String ville;
    @Column(name ="date_creation")
    private Date dateCreation;
    @Column(name ="code_postal")
    private int codePostal;
    @ManyToOne
    @JoinColumn(name="idCountry", nullable=false)
    CountryEntity country;
}
