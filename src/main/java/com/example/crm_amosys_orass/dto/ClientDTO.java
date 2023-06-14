package com.example.crm_amosys_orass.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
@Component
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDTO {
    private Long idClient;
    private  Long idCountry;
    private  Long id;
    private String entreprisePrincipal;
    private String siteWebEntreprise;
    private String nomPrenom;
    private String codeClient;
    private String  fax;
    private String teleFixe;
    private String email;
    private LocalDate dateCreatClient;
    private String country;
    private String produits;
    private Long idproduit;
    private String linkdin;
    private String registerCommercial;
    private String chifreDaffir;
    private String nombreEmploye;
    private LocalDate dateAgrement;
    private String logo;
}