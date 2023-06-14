package com.example.crm_amosys_orass.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DocumentationDTO {
    private Long id;
   //private Long idClient;
    //private Long client;
    private Long idDocument;
    private String name;
    private String type;
    private byte[] fils;

}
