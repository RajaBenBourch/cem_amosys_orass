package com.example.crm_amosys_orass.model;

import com.example.crm_amosys_orass.dto.ClientDTO;
import com.example.crm_amosys_orass.dto.ContactDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id_client;

    @Column(name ="Entreprise_Principal")
    private String entreprise_Principal;
    @Column(name ="SiteWeb_Entreprise")
    private String siteWeb_Entreprise;
    @Column(name ="Nom_Prenom")
    private String nom_Prenom;
    @Column(name ="Code_Client")

    private String code_Client;
    @Column(name ="Fax")
    private String  fax;

    @Column(name ="Tele_Fix")
    private String teleFixe;

    @Column(name ="E_mail")
    private String email;
    @Column(name ="Date_creat_Client")
    private Date date_creat_client;
    @ManyToOne
    @JoinColumn(name = "idCountry")
    private CountryEntity country;

    @OneToMany(mappedBy = "client")
    private List<ContactEntity> contacts;

}
