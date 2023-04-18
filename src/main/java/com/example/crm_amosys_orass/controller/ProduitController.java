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


    @PostMapping("/")
    public ProduitDTO save(@Valid @RequestBody ProduitDTO produitDto) {
        return produitService.save(produitDto);
    }

    @GetMapping("/ref/{ref}")
    public ProduitDTO findByRef(@PathVariable String ref) {
        return produitService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int delete(@PathVariable String ref) {
        return produitService.delete(ref);
    }

    @PutMapping("/")
    public ProduitDTO update(@Valid @RequestBody ProduitDTO produitDto) {
        return produitService.update(produitDto);
    }

    @GetMapping("/")
    public List<ProduitDTO> findAll() {
        return produitService.findAll();
    }
}