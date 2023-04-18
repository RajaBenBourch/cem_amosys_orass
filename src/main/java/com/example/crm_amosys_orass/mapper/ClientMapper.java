package com.example.crm_amosys_orass.mapper;

import com.example.crm_amosys_orass.dto.ClientDTO;
import com.example.crm_amosys_orass.model.ClientEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientMapper extends BaseMapper<ClientEntity, ClientDTO>{


    public ClientMapper(ClientEntity client, ClientDTO clientDto) {
        super(client, clientDto);
    }

    /*public ClientToClientDTO(ModelMapper modelMapper) {
                    super(modelMapper);
                }*/
    public List<ClientDTO> ToClientDtos(List<ClientEntity> clients) {
        List<ClientDTO> dtos = new ArrayList<>();
        for (ClientEntity client: clients) {
            ClientDTO dto = toClientDto(client);
            dtos.add(dto);
        }
        return dtos;
    }

    public ClientEntity toClient(ClientDTO clientDTO){
        /*ClientEntity client = new ClientEntity();
       client.setNom_Prenom(clientDTO.getNom_Prenom());
        client.setId_client(client.getId_client());
        client.setCountry(client.getCountry());
        client.setDate_creat_client(client.getDate_creat_client());
        client.setCode_Client(client.getCode_Client());
        client.setSiteWeb_Entreprise(client.getSiteWeb_Entreprise());
        client.setEntreprise_Principal(client.getEntreprise_Principal());
        client.setTeleFixe(client.getTeleFixe());*/


         ClientEntity client = toEntity(clientDTO);
        return client;
    }

    public ClientDTO toClientDto(ClientEntity client){
            ClientDTO clientDto =  new ClientDTO();
            clientDto.setCountry(client.getCountry().getNomCountry());
            clientDto.setCodeClient(client.getCodeClient());
            clientDto.setFax(client.getFax());
            clientDto.setIdClient(client.getIdClient());
            clientDto.setDateCreatClient(client.getDateCreatClient());
            clientDto.setEntreprisePrincipal(client.getEntreprisePrincipal());
            clientDto.setEmail(client.getEmail());
            clientDto.setTeleFixe(client.getTeleFixe());
            clientDto.setSiteWebEntreprise(client.getSiteWebEntreprise());
            return clientDto;

    }
}
