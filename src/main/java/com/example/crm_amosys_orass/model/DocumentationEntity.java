package com.example.crm_amosys_orass.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Table(name = "crm_document")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class DocumentationEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idDocument;
        private String name;
        private String type;
        @Lob
        @Column(name = "imagedata", length = 1000)
        private byte[] fils;
        @ManyToOne
        @JoinColumn(name = "id")
        ProduitEntity produits;

      /*  @OneToOne
        @JoinColumn(name = "idClient")
        ClientEntity client;*/
}