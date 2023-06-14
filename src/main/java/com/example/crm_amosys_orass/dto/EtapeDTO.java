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
public class EtapeDTO {
    private  Long idEtape;
    private String name;
    private Long idOpportunity;
    private  String opportunite;

}
