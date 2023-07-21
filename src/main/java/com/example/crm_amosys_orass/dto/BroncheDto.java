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
public class BroncheDto {
    private long idBronch;
    private String nomBronche;

}
