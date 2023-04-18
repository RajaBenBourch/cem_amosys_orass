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
public class ClientDTO {
    private Long idClient;

    private  Long idCountry;
    private String entreprisePrincipal;

    private String siteWebEntreprise;

    private String nomPrenom;


    private String codeClient;

    private String  fax;


    private String teleFixe;


    private String email;

    private Date dateCreatClient;


    private String country;



}