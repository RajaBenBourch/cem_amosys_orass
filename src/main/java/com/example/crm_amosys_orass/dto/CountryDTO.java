package com.example.crm_amosys_orass.dto;

import com.example.crm_amosys_orass.model.ClientEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CountryDTO {
    private long idCountry;
    private long idVille;
    private String villes;
    private String nomCountry;
    private String codePostal;
    private Date dateCreatCountry;


}
