package com.example.crm_amosys_orass.dto;

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
public class VilleDto {

    private long idVille;
    private long idCountry;
    private String ville;
    private Date dateCreation;
    private int codePostal;
}
