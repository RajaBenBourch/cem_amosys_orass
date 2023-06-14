package com.example.crm_amosys_orass.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Entity
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "crm_Opportunite_etape")
public class EtapeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idEtape;
    private String name;
        // Constructors, getters, and setters
   @OneToMany(mappedBy = "etape", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OpportuniteEntity> opportunite;

}
