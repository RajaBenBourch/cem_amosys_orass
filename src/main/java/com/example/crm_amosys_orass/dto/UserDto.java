package com.example.crm_amosys_orass.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
@Component
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private  Long idUser;
    private String nom;
    private String Prenom;
    private String cni;
    private String email;
    private String Password;
}
