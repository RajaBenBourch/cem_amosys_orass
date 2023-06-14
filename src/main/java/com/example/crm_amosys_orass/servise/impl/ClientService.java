package com.example.crm_amosys_orass.servise.impl;
import com.example.crm_amosys_orass.dto.ClientDTO;
import com.example.crm_amosys_orass.dto.ContactDTO;
import com.example.crm_amosys_orass.dto.LogoDto;
import com.example.crm_amosys_orass.mapper.ClientMapper;
import com.example.crm_amosys_orass.mapper.ContactMapper;
import com.example.crm_amosys_orass.mapper.LogoMapper;
import com.example.crm_amosys_orass.model.*;
import com.example.crm_amosys_orass.repository.*;
import com.example.crm_amosys_orass.utils.IGenericMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
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
    private IGenericMapper iGenericMapper;
    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private ContactMapper contactMapper;
    @Autowired
    private  LogoRepository logoRepository;
    public ClientDTO getById(Long idClient) {
        Optional<ClientEntity> emp = this.clientRepository.findById(idClient);
        if (emp.isEmpty()){
            throw new ResourceNotFoundException("Country not found for this id ");
        }
        return iGenericMapper.map(emp.get(),ClientDTO.class);

    }
    //******************getlist client avant de devlopper function search***********//
    /*public List<ClientDTO> getAll(){
        List<ClientEntity> clients = clientRepository.findAll();

        return clientMapper.ToClientDtos(clients);
    }*/


    public List<ClientDTO> getAll() {
        List<ClientEntity> clients = clientRepository.findAll();
        return clientMapper.ToClientDtos(clients);
    }

    public List<ClientDTO> searchClients(String keyword) {
        List<ClientEntity> clients = clientRepository.searchClients(keyword);
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
    public void save(ClientDTO client){
        /*if(client.getId_client() != null){
            ClientEntity
        }*/
        CountryEntity country = countryRepository.findById(client.getIdCountry()).get();
        if(country == null){
            //throw error
        } else{
            ClientEntity clientEntity = clientMapper.toClient(client);
            clientEntity.setCountry(country);
            clientRepository.save(clientEntity);
        }
        //return iGenericMapper.map(clientRepository.save(iGenericMapper.map(client, ClientEntity.class)),ClientDTO.class);
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
                .client(client)
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


}