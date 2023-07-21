package com.example.crm_amosys_orass.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.List;
@Component
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDTO {
    private Long idClient;
    private  Long idCountry;
    private  Long idLogo;
    private Long idUser;
    private long idBronch;
    private String entreprisePrincipal;
    private String siteWebEntreprise;
    private String nomPrenom;
    private String codeClient;
    private String  fax;
    private String teleFixe;
    private String email;
    private LocalDate dateCreatClient;
    private String country;
    private String user;
    private String bronche;
    private String produits;
    private Long idproduit;
    private String linkdin;
    private String registerCommercial;
    private String chifreDaffir;
    private String nombreEmploye;
    private LocalDate dateAgrement;
    private String logo;
    private List<MetaDataDto> metaData;

}