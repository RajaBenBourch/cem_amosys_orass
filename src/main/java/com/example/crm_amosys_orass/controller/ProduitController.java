package com.example.crm_amosys_orass.controller;

import com.example.crm_amosys_orass.dto.ClientDTO;
import com.example.crm_amosys_orass.dto.ProduitDTO;
import com.example.crm_amosys_orass.servise.impl.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/produits")
@RequiredArgsConstructor
public class ProduitController {

    private final ProduitService produitService;


    @GetMapping("/crm_produit_information")
    public ResponseEntity<List<ProduitDTO>>getAllProduit(){
        return new ResponseEntity<>(produitService.findAll(),HttpStatus.OK);

    }



    @PostMapping("/create_crm_produit_information")
    public ResponseEntity<List<ProduitDTO>> save(@RequestBody ProduitDTO produitDTO){
        System.out.println(produitDTO);
        produitService.save(produitDTO);
        return new ResponseEntity<>(produitService.findAll(),HttpStatus.OK);
    }



    @GetMapping("/id/{id}")
    public ResponseEntity<ProduitDTO>findById(@PathVariable Integer id){
        return new ResponseEntity<>(produitService.findById(id),HttpStatus.OK);
    }



    @PutMapping("/updat_crm_produit_information")
    public  ResponseEntity<ProduitDTO> update(@RequestBody ProduitDTO produitDto){
        return new ResponseEntity<>(produitService.update(produitDto),HttpStatus.OK);
    }
    @DeleteMapping("/delete_crm_produit_information/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        produitService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}