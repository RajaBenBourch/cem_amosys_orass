package com.example.crm_amosys_orass.controller;
import com.example.crm_amosys_orass.dto.*;
import com.example.crm_amosys_orass.mapper.ProduitClientMapper;
import com.example.crm_amosys_orass.mapper.ProduitMapper;
import com.example.crm_amosys_orass.model.*;
import com.example.crm_amosys_orass.repository.ClientRepository;
import com.example.crm_amosys_orass.repository.ProduitClientEntityRepository;
import com.example.crm_amosys_orass.repository.ProduitRepository;
import com.example.crm_amosys_orass.servise.impl.ClientService;
import com.example.crm_amosys_orass.servise.impl.ProduitService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ClientController {
    @Autowired
    private ClientService clientServise;
    @Autowired
    private ProduitMapper produitMapper;
    @Autowired
    private ProduitClientMapper produitClientMapper;
    @Autowired
    private ProduitService produitService;
    @Autowired
    private ProduitClientEntityRepository produitClientEntityRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping("/crm_client_information")
    /*public ResponseEntity<List<ClientDTO>>getAllClient(){
       // List<ClientDTO> ListClient=clientServise.getAll(keyword);
        return new ResponseEntity<>(clientServise.getAll(),HttpStatus.OK);

    }*/
    public ResponseEntity<List<ClientDTO>> getAllClient(@RequestParam(required = false) String keyword) {
        List<ClientDTO> clients;
        if (keyword != null && !keyword.isEmpty()) {
            clients = clientServise.searchClients(keyword);
        } else {
            clients = clientServise.getAll();
        }
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    //getclient
    @GetMapping("/crm_client_information/{id_client}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable long idClient){
        return new ResponseEntity<>(clientServise.getById(idClient),HttpStatus.OK);
    }

    @GetMapping("/crm_client_contact/{idClient}")
    public ResponseEntity<List<ContactDTO>> getClientContact(@PathVariable long idClient){
        return new ResponseEntity<>(clientServise.getContact(idClient),HttpStatus.OK);
    }
    //save client
    @GetMapping("/delete_crm_client_contact/{idContact}")
    public ResponseEntity<List<ContactDTO>> deleteContact(@PathVariable long idContact){
        return new ResponseEntity<>(clientServise.deleteContact(idContact),HttpStatus.OK);
    }
    @PostMapping("/create_crm_client_information")
    public ResponseEntity<List<ClientDTO>> save(@RequestBody ClientDTO client ,String keyword) {
        System.out.println(client);
        clientServise.save(client);
        return new ResponseEntity<>(clientServise.getAll(),HttpStatus.OK);
    }
    @PostMapping (path = "affectation-produit-client")
    public List<ProduitDTO> listeproduitToClient (@RequestBody ProduitClientDTO achat){
        ClientEntity client = clientRepository.findClientEntityByIdClient(achat.getIdClient());
        ProduitEntity p = produitRepository.findProduitEntitiesById(achat.getId());
        ProduitClientEntity produitClientEntity = new ProduitClientEntity();
        produitClientEntity.setClient(client);
        produitClientEntity.setProduit(p);
        produitClientEntity.setDateAchatP(new Date());
        produitClientEntity.setPrixAchatProduit(achat.getPrixAchatProduit());
        produitClientEntityRepository.save(produitClientEntity);
        return  getproduitByClient(achat.getIdClient());
    }
    @GetMapping (path = "/produitsByClient/{idC}")
    public List<ProduitDTO> getproduitByClient(@PathVariable Long idC) {
        List<ProduitDTO> produitsList = new ArrayList();
        Optional<ClientEntity> clientOp=clientRepository.findById(idC);
        ClientEntity client = clientOp.get();
        ProduitClientEntity produitClientEntity;
        List<ProduitClientEntity> produitClientEntities = client.getProduits();
        ProduitEntity produit ;
        ProduitClientEntity p;
        for (ProduitClientEntity produitclint: client.getProduits()) {
            p = null;
            for(int i = 0; i < produitClientEntities.size(); i++){
                if(produitClientEntities.get(i).getClient().getIdClient() == idC){
                    p = produitClientEntities.get(i);
                    break;
                }
            }
            ProduitDTO dto = produitMapper.toProduitDTO(produitclint.getProduit());
            dto.setDateAchatP(p.getDateAchatP());
            dto.setPrixAchatProduit(p.getPrixAchatProduit());
            produitsList.add(dto);
        }
        return  produitsList;
    }
    //*********
    @PostMapping("/create_crm_client_contact")
    public ResponseEntity<List<ContactDTO>> mergeContact(@RequestBody ContactDTO contact){
        clientServise.mergeContact(contact);
        return new ResponseEntity<>(clientServise.getContact(contact.getIdClient()),HttpStatus.OK);
    }
    @PutMapping("/update_crm_client_information")
    public  ResponseEntity<ClientDTO> update(@RequestBody ClientDTO client){
        return new ResponseEntity<>(clientServise.update(client),HttpStatus.OK);
    }
    //delete country
    @GetMapping("/delete_crm_client_information/{idClient}")
    public ResponseEntity<List<ClientDTO>> delete(@PathVariable long idClient){
        clientServise.delete(idClient);
        return new ResponseEntity<>(HttpStatus.OK);
        }
    @PostMapping("/client/documents/{clientId}")
    public ResponseEntity<LogoDto> createDocumentForClient(
            @PathVariable Long clientId,
            @RequestParam("file") MultipartFile file

    ) {
        try {
            byte[] fileData = file.getBytes();
            LogoDto logoDto = clientServise.createLogoForClient(clientId, file.getName(), file.getContentType(), fileData);
            return ResponseEntity.ok(logoDto);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

   /* @GetMapping("/client/{clientId}")
    public ResponseEntity<List<DocumentationEntity>> getDocumentsForClient(@PathVariable Long idClient) {
        try {
            List<DocumentationEntity> documents = clientServise.getDocumentsForClient(idClient);
            return ResponseEntity.ok(documents);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<LogoEntity>> getLogosForClient(@PathVariable Long idClient) {
        try {
            List<LogoEntity> logos = clientServise.getLogosForClient(idClient);
            return ResponseEntity.ok(logos);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }*/



}

