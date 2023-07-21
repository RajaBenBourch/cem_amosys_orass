package com.example.crm_amosys_orass.controller;
import com.example.crm_amosys_orass.dto.ProduitClientDTO;
import com.example.crm_amosys_orass.dto.ProduitDTO;
import com.example.crm_amosys_orass.model.ClientEntity;
import com.example.crm_amosys_orass.repository.ClientRepository;
import com.example.crm_amosys_orass.repository.ProduitRepository;
import com.example.crm_amosys_orass.servise.impl.ProduitClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/clientProduit")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ClientProduitController {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProduitClientService produitClientService;
    @Autowired
    private ProduitRepository produitRepository;
    public ClientProduitController(ClientRepository clientRepository,
                                   ProduitRepository produitRepository) {
        this.clientRepository = clientRepository;
        this.produitRepository =produitRepository;
    }
    @PostMapping
    public ClientEntity saveclientWithproduit(@RequestBody ClientEntity client){
        return   clientRepository.save(client);
    }

    @GetMapping
    public List<ClientEntity> findALlClient(){
        return clientRepository.findAll();
    }

    @GetMapping("/{clientid}")
    public ClientEntity findStudent(@PathVariable Long studentId){
        return clientRepository.findById(studentId).orElse(null);
    }

    @DeleteMapping("/delete_crm_client_produit/{idProduitClient}")
    public ResponseEntity<List<ProduitDTO>> deleteContact(@PathVariable long idProduitClient){
        return new ResponseEntity<>(produitClientService.deleteProduitClient(idProduitClient), HttpStatus.OK);
    }

    @PutMapping("/update_crm_client_produit")
    public  ResponseEntity<List<ProduitDTO>> update(@RequestBody ProduitClientDTO produitClientDTO){
        return new ResponseEntity<>(produitClientService.update(produitClientDTO),HttpStatus.OK);
    }

    /*@GetMapping("/find/{name}")
    public List<ClientEntity> findStudentsContainingByName(@PathVariable String name){
        return clientRepository.findByNameContaining(name);
    }*/

   /* @GetMapping("/search/{price}")
    public List<ProduitEntity> findCourseLessThanPrice(@PathVariable String name){
        return produitRepository.findByNameContaining(name);
    }*/



}
