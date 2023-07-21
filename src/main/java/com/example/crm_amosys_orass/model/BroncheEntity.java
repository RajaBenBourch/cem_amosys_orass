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
@Table(name = "crm_Bronche_Assirance")
public class BroncheEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long idBronch;
    @Column(name ="nom_bronche")
    private String nomBronche;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClientEntity> clients;

}
