package com.example.crm_amosys_orass.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "crm_client_information")
public class ClientEntity {
    //Classe Client
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long idClient;

    @Column(name ="Entreprise_Principal")
    private String entreprisePrincipal;
    @Column(name ="SiteWeb_Entreprise")
    private String siteWebEntreprise;
    @Column(name ="Nom_Prenom")
    private String nomPrenom;
    @Column(name ="Code_Client")

    private String codeClient;
    @Column(name ="Fax")
    private String  fax;

    @Column(name ="Tele_Fix")
    private String teleFixe;

    @Column(name ="E_mail")
    private String email;
    @Column(name ="Date_creat_Client")
    private Date dateCreatClient;
    @ManyToOne
    @JoinColumn(name = "idCountry")
    private CountryEntity country;

    @OneToMany(mappedBy = "client")
    private List<ContactEntity> contacts;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateAchatP;
    /*@ManyToMany
    @JoinTable(name="user_produit",joinColumns = @JoinColumn(name="id_client"),
    inverseJoinColumns = @JoinColumn(name = "idProduit"))
    private List<ProduitEntity> produit;*/

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FactureEntity> factures;



  /*  @ManyToMany
    @JoinTable(
            name = "client_produit",
            joinColumns = @JoinColumn(name = "idClient"),
            inverseJoinColumns = @JoinColumn(name = "idProduit"))
    private Set<ProduitEntity> produits = new HashSet<>();
*/
}
