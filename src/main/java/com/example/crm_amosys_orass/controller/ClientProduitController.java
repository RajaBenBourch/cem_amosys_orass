package com.example.crm_amosys_orass.controller;

import com.example.crm_amosys_orass.model.ClientEntity;
import com.example.crm_amosys_orass.model.ProduitEntity;
import com.example.crm_amosys_orass.repository.ClientRepository;
import com.example.crm_amosys_orass.repository.ProduitRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientProduit")
@CrossOrigin(origins = "*")
public class ClientProduitController {
    private ClientRepository clientRepository;

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
    /*@GetMapping("/find/{name}")
    public List<ClientEntity> findStudentsContainingByName(@PathVariable String name){
        return clientRepository.findByNameContaining(name);
    }*/

   /* @GetMapping("/search/{price}")
    public List<ProduitEntity> findCourseLessThanPrice(@PathVariable String name){
        return produitRepository.findByNameContaining(name);
    }*/
}
