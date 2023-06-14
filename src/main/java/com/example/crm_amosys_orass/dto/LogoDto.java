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
public class LogoDto {
    private Long id;
    private Long idClient;
    private String client;
    private String name;
    private String type;
    private byte[] fils;

}
