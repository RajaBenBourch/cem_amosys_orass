package com.example.crm_amosys_orass.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Date;
@Entity
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "crm_client_contact")
public class ContactEntity {
//Classe Client
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long idContact;

    @Column(name ="nom")
    private String nom;
    @Column(name ="role")
    private String role;
    @Column(name ="email")
    private String email;

    @Column(name ="fax")
    private String  fax;

    @Column(name ="telephone")
    private String teleFixe;

    @Column(name ="date")
    private Date date;

    @ManyToOne
    @JoinColumn(name="idClient", nullable=false)
    ClientEntity client;
}
