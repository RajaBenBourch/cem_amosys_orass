package com.example.crm_amosys_orass.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Entity
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "crm_client_information")
public class ClientEntity {
    //Classe Client
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    @Column(name = "Entreprise_Principal")
    private String entreprisePrincipal;
    @Column(name = "SiteWeb_Entreprise")
    private String siteWebEntreprise;
    @Column(name = "Nom_Prenom")
    private String nomPrenom;
    @Column(name = "Code_Client")

    private String codeClient;
    @Column(name = "Fax")
    private String fax;

    @Column(name = "Tele_Fix")
    private String teleFixe;

    @Column(name = "E_mail")
    private String email;

    @Column(name ="Linkdin")
    private String linkdin;

    @Column(name ="Register_Commercial")
    private String registerCommercial;

    @Column(name ="Chifre_D'affir")
    private String chifreDaffir;
    @Column(name ="nombre_Employe")
    private String nombreEmploye;

    @DateTimeFormat(pattern = "yyyy-MM-dd") // Specify the date pattern
    @Column(name = "Date_creat_Client")


    private LocalDate dateCreatClient;
    @DateTimeFormat(pattern = "yyyy-MM-dd") // Specify the date pattern
    @Column(name = "DateAgrement")

    private LocalDate dateAgrement;
    @ManyToOne
    @JoinColumn(name = "idCountry")
    private CountryEntity country;

    @OneToMany(mappedBy = "client")
    private List<ContactEntity> contacts;
    //    lllllll
    //    @OneToMany
   //     List<ProduitEntity> produits;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateAchatP;
    @OneToMany(mappedBy = "client")
    private List<ProduitClientEntity> produits;
   // @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
   @OneToMany(mappedBy = "client")
    private List<OpportuniteEntity> opportunites;
    @OneToOne
    @JoinColumn(name = "id")
    private LogoEntity logo;
}
