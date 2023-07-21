package com.example.crm_amosys_orass.dto;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Date;
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MetaDataDto {
    private Long idClient;

    private Long idMeta;
    private String idville;
    private String ville;
    private String timeZone;
    private String teleFixe;
    private String identifiantfiscal;
    private Date lagrement;
    private String email;
    private String logo;
    private String typeActivite;
}
