package com.example.crm_amosys_orass.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "crm_client_logo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class LogoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idLogo;
    private String name;
    private String type;
    @Lob
    @Column(name = "imagedata", length = 1000, columnDefinition="BLOB")
    private byte[] fils;
    @OneToOne
    private  ClientEntity client;

}
