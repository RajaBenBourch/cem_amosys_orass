package com.example.crm_amosys_orass.controller;

import com.example.crm_amosys_orass.dto.ClientProduitDTO;
import com.example.crm_amosys_orass.dto.CountryDTO;
import com.example.crm_amosys_orass.dto.ProduitDTO;
import com.example.crm_amosys_orass.servise.impl.ClientProduitService;
import com.example.crm_amosys_orass.servise.impl.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//@RequestMapping("/api/V1")
@CrossOrigin(origins = "*")
public class ClientProduitController {
    @Autowired
    private ClientProduitService clientProduitService;
    @GetMapping("/get_crm_clientProduit")
    public ResponseEntity<List<ClientProduitDTO>> getAllClientProduit(){
        return new ResponseEntity<>(clientProduitService.getAll(), HttpStatus.OK);
    }
    @PostMapping("/create_crm_ProduiClients")
    public ClientProduitDTO saveProduitClient(@Valid @RequestBody ClientProduitDTO clientProduitDTO) {
        return clientProduitService.save(clientProduitDTO);
    }





}
