package com.example.crm_amosys_orass.servise.impl;
import com.example.crm_amosys_orass.dto.ClientDTO;
import com.example.crm_amosys_orass.dto.ContactDTO;
import com.example.crm_amosys_orass.dto.LogoDto;
import com.example.crm_amosys_orass.dto.MetaDataDto;
import com.example.crm_amosys_orass.mapper.ClientMapper;
import com.example.crm_amosys_orass.mapper.ContactMapper;
import com.example.crm_amosys_orass.mapper.LogoMapper;
import com.example.crm_amosys_orass.mapper.MetaDataMapper;
import com.example.crm_amosys_orass.model.*;
import com.example.crm_amosys_orass.repository.*;
import com.example.crm_amosys_orass.utils.IGenericMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private LogoMapper logoMapper ;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private MetaDataRepository  metaDataRepository;
    @Autowired
    private MetaDataMapper metaDataMapper;
    @Autowired
    private IGenericMapper iGenericMapper;
    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private ContactMapper contactMapper;
    @Autowired
    private  LogoRepository logoRepository;

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private  BroncheRepository broncheRepository ;
    public ClientDTO getById(Long idClient) {
        Optional<ClientEntity> emp = this.clientRepository.findById(idClient);
        if (emp.isEmpty()){
            throw new ResourceNotFoundException("   Client not found for this id ");
        }
        return iGenericMapper.map(emp.get(),ClientDTO.class);

    }



    //******************getlist client avant de devlopper function search***********//
    /*public List<ClientDTO> getAll(){
        List<ClientEntity> clients = clientRepository.findAll();

        return clientMapper.ToClientDtos(clients);
    }*/


    public List<ClientDTO> getAll() {
        List<ClientEntity> clients = clientRepository.findAll(Sort.by(Sort.Direction.ASC, "entreprisePrincipal"));
        return clientMapper.ToClientDtos(clients);
    }
    public List<ClientDTO> searchClients(String keyword) {
        List<ClientEntity> clients = clientRepository.searchClients(keyword);
       // List<ClientEntity> clients = clientRepository.searchClients(keyword);
        return clientMapper.ToClientDtos(clients);
    }




    /************************searche*************************
    @Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    public List<Product> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    ...
}
  **********************************************************************/
/*
    public List<ClientEntity> findAll(){
        List<ClientEntity> client = clientRepository.findAllByOrderByIdClientAsc();
        return client;
    }
*/
    //les function qui adabte relation client user branche logo
    /*public void save(ClientDTO client){

        ClientEntity clientEntity = clientMapper.toClient(client);
        CountryEntity country = countryRepository.findById(client.getIdCountry()).get();
        if(client.getIdLogo() != null){
        Optional<LogoEntity> logo = logoRepository.findById(client.getIdLogo());
            clientEntity.setLogo(logo.get());}
        if(country == null ){
            //throw error
        } else{
            clientEntity.setCountry(country);
            clientRepository.save(clientEntity);
        }
        //return iGenericMapper.map(clientRepository.save(iGenericMapper.map(client, ClientEntity.class)),ClientDTO.class);
    }*/



   public void save(ClientDTO client) {
        ClientEntity clientEntity = clientMapper.toClient(client);

        CountryEntity country = countryRepository.findById(client.getIdCountry()).orElse(null);
        if (country == null) {
            // Gérer l'erreur lorsque le pays n'est pas trouvé
        } else {
            clientEntity.setCountry(country);

            if (client.getIdLogo() != null) {
                Optional<LogoEntity> logo = logoRepository.findById(client.getIdLogo());
                if (logo.isPresent()) {
                    clientEntity.setLogo(logo.get());
                } else {
                    // Gérer l'erreur lorsque le logo n'est pas trouvé
                }
            }

            UserEntity user = userRepository.findById(client.getIdUser()).orElse(null);
            if (user != null) {
                clientEntity.setUser(user);
            } else {
                // Gérer l'erreur lorsque l'utilisateur n'est pas trouvé
            }

            BroncheEntity branch = broncheRepository.findById(client.getIdBronch()).orElse(null);
            if (branch != null) {
                clientEntity.setBronche(branch);
            } else {
                // Gérer l'erreur lorsque la succursale n'est pas trouvée
            }

            clientRepository.save(clientEntity);
        }
    }



    public ClientDTO update(ClientDTO client){
        Optional<ClientEntity> emp = this.clientRepository.findById(client.getIdClient());
        if (emp.isEmpty()){
            throw new ResourceNotFoundException("Country not found for this id ");
        }

        return iGenericMapper.map(clientRepository.save(iGenericMapper.map(client, ClientEntity.class)),ClientDTO.class);
    }

    public void  delete(long idClient){
        this.clientRepository.deleteById(idClient);
    }

    public List<ContactDTO>  deleteContact(long idContact){
        ContactEntity contact = contactRepository.findById(idContact).get();
        contactRepository.deleteById(idContact);
        return getContact(contact.getClient().getIdClient());
    }
    public List<ContactDTO> getContact(long idClient) {
        Optional<ClientEntity> client = clientRepository.findById(idClient);
        List<ContactEntity> contacts = client.get().getContacts();
        return contactMapper.ToContactDtos(contacts);
    }
    public void mergeContact(ContactDTO contactDto) {
        ClientEntity client = clientRepository.findById(contactDto.getIdClient()).get();
        ContactEntity contact = contactMapper.toContact(contactDto);
        contact.setClient(client);
        contact = contactRepository.save(contact);
        List<ContactEntity> contactEntities = client.getContacts();
        contactEntities.add(contact);
        client.setContacts(contactEntities);
        clientRepository.save(client);
    }
    public LogoDto createLogoForClient(Long idClient, String name, String type, byte[] fileData) {
        ClientEntity client = clientRepository.findById(idClient)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with ID: " + idClient));
      //ProduitEntity produitEntity =produitRepository.findById(3L).orElseThrow(() -> new EntityNotFoundException("Client not found with ID: " + idClient));
        LogoEntity logo = LogoEntity.builder()
                .name(name)
                .type(type)
                ///.client(client)
                .fils(fileData)
             // .produits(produitEntity)
                .build();
        //document.setProduits(client.getProduits().get(0).getProduit());
        LogoEntity ds = logoRepository.save(logo);
        client.setLogo(ds);
        clientRepository.save(client);
        return logoMapper.toDTO(ds);
    }
    /*public List<DocumentationEntity> getLogosForClient(Long idClient) {
        ClientEntity client = clientRepository.findById(idClient).orElseThrow(() -> new EntityNotFoundException("Client not found"));
        return logoRepository.findByClient(client);
    }*/
    public ClientDTO getClientWithMetaData(Long clientId) {
        Optional<ClientEntity> clientOptional = clientRepository.findById(clientId);
        if (clientOptional.isPresent()) {
            ClientEntity clientEntity = clientOptional.get();

            ClientDTO clientDTO = clientMapper.toClientDto(clientEntity);
            List<MetaDataDto> metaDataDTOs = metaDataMapper.ToMetaDataDtos(clientEntity.getMetaData());
            clientDTO.setMetaData(metaDataDTOs);

            return clientDTO;
        } else {
            // Gérer le cas où le client n'est pas trouvé
            throw new EntityNotFoundException("Client not found with ID: " + clientId);
        }
    }

}