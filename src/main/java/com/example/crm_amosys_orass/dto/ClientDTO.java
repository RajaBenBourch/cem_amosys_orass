package com.example.crm_amosys_orass.dto;

import com.example.crm_amosys_orass.model.ClientEntity;
import com.example.crm_amosys_orass.model.CountryEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDTO {
    private Long id_client;

    private  Long idCountry;
    private String entreprise_Principal;

    private String siteWeb_Entreprise;

    private String nom_Prenom;


    private String code_Client;

    private String  fax;


    private String teleFixe;


    private String email;

    private Date date_creat_client;


    private String country;



}
