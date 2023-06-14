package com.example.crm_amosys_orass.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "crm_country_information")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
        private long idCountry;
    @Column(name ="nom_country")
        private String nomCountry;
    @Column(name ="code_postal")

    private String codePostal;

    @Column(name ="date_creat_country")
        private Date dateCreatCountry;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClientEntity> clients;
}
