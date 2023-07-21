package com.example.crm_amosys_orass.dto;

import com.example.crm_amosys_orass.model.ClientEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;

@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContactDTO {

    private long idClient;
    private long idContact;
    private String nomContact;
    private String roleContact;
    private Date dateCreate;
    private String email;
    private String telephone;
    private String fax;

}
