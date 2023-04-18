package com.example.crm_amosys_orass.dto;

import lombok.Data;

import java.util.List;
@Data
public class FactureDTO {

    private String ref;

    private String codeClient;

    List<LigneFactureDTO> ligneFactureDtoList;
}
