package com.example.crm_amosys_orass.mapper;

import com.example.crm_amosys_orass.dto.ClientDTO;
import com.example.crm_amosys_orass.dto.ClientProduitDTO;
import com.example.crm_amosys_orass.model.ClientEntity;
import com.example.crm_amosys_orass.model.ClientProduitEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientProduitMapper extends BaseMapper<ClientProduitEntity, ClientProduitDTO>{


    public ClientProduitMapper(ClientProduitEntity clientProduitEntity, ClientProduitDTO clientProduitDTO) {
        super(clientProduitEntity, clientProduitDTO);
    }
    public List<ClientProduitDTO> ToClientProduitDtos(List<ClientProduitEntity> clientsproduits) {
        List<ClientProduitDTO> dtos = new ArrayList<>();
        for (ClientProduitEntity clientproduit: clientsproduits) {
            ClientProduitDTO dto = toClientProduitDto(clientproduit);
            dtos.add(dto);
        }
        return dtos;
    }

    public ClientProduitEntity toClientProduit(ClientProduitDTO clientProduitDTO ){
        ClientProduitEntity clientProduit = new ClientProduitEntity();
        clientProduit.setClient(clientProduit.getClient());
        clientProduit.setProduit(clientProduit.getProduit());
        clientProduit.setDateAchatP(clientProduit.getDateAchatP());
        ClientProduitEntity clientproduit = toEntity(clientProduitDTO);
        return clientproduit;


    }
    public ClientProduitDTO toClientProduitDto(ClientProduitEntity clientProduitEntity){
        ClientProduitDTO  clientProduitDTO =  new ClientProduitDTO ();
        clientProduitDTO.setClient(clientProduitEntity.getClient()/*.getNomCountry()*/);
        clientProduitDTO.setProduit(clientProduitEntity.getProduit());
        clientProduitDTO.setDateAchatP(clientProduitEntity.getDateAchatP());
        return clientProduitDTO;

    }




}
