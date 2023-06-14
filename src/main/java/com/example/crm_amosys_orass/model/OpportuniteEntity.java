package com.example.crm_amosys_orass.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "crm_opportunities_information")
@Builder
@Component
public class OpportuniteEntity {
//Type
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idOpportunity;
        private String name;
      //  private String stage;
        private LocalDate closeDate;
        private String Statu;
        @ManyToOne
        @JoinColumn(name = "idUser")
        private UserEntity user;


        /*@ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "idClient")
        private ClientEntity client;*/

        @ManyToOne
        @JoinColumn(name="idEtape", nullable = false)
         private EtapeEntity etape;


    //@ManyToOne(fetch = FetchType.LAZY)
  /******  @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idEtape")
    EtapeEntity etape1;*******/
        @OneToMany(mappedBy = "opportunite", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<ProduitOpportuniterEntity> produits;
      /*  @ManyToMany
        @JoinTable(name = "opportunity_product",
                joinColumns = @JoinColumn(name = "idOpportunity"),
                inverseJoinColumns = @JoinColumn(name = "idProduct"))
        private Set<ProduitEntity> products = new HashSet<>();*/

    //*********************************************************************************

   @ManyToOne
    @JoinColumn(name = "idClient")
    private ClientEntity client;

}
