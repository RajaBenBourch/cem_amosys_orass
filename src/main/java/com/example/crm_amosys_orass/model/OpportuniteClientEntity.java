package com.example.crm_amosys_orass.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
//@Table(name = "crm-opportuniter-client")

public class OpportuniteClientEntity {
    @Id
    private  Long id;
    //private Long idClient ;
   // private Long idOpportunity;

}

