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
public class RoleDto {
    private Long idRole;
    private String nom;


}
