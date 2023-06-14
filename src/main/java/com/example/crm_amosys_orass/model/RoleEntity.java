package com.example.crm_amosys_orass.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
@Entity
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "crm_Role_information")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long idRole;
    private String nom;
    private String cni;

}
