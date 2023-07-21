package com.example.crm_amosys_orass.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import java.util.Date;
@Entity
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "crm_client_contact")
public class ContactEntity {
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
    private String fax;
    @Column(name ="telephone")
    private String teleFixe;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name ="date")
    private Date dateCreate;
    @ManyToOne
    @JoinColumn(name="idClient", nullable=false)
    ClientEntity client;
}
