package com.example.crm_amosys_orass.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
@Entity
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "crm_User")
public class UserEntity {

    @Id
    @GeneratedValue

    private Long idUser;

    private String nom;

    private String Prenom;

    private String cni;
    @Column(nullable=false, unique=true)
    private String email;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<OpportuniteEntity>opprtunity;




}
