package com.example.crm_amosys_orass.controller;

import com.example.crm_amosys_orass.dto.ClientDTO;
import com.example.crm_amosys_orass.dto.ProduitDTO;
import com.example.crm_amosys_orass.model.DocumentationEntity;
import com.example.crm_amosys_orass.model.ProduitEntity;
import com.example.crm_amosys_orass.repository.DocumentationRepository;
import com.example.crm_amosys_orass.repository.ProduitRepository;
import com.example.crm_amosys_orass.servise.impl.ProduitService;
import com.example.crm_amosys_orass.utils.FileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Base64;
import java.util.List;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/produits")
@RequiredArgsConstructor
public class ProduitController {

    private final ProduitService produitService;
   @Autowired
    ProduitRepository produitRepository;
    @Autowired
    DocumentationRepository documentationRepository;


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
    public ResponseEntity<ProduitDTO>findById(@PathVariable Long id){
        return new ResponseEntity<>(produitService.findProduitEntitiesById(id),HttpStatus.OK);
    }
    @PutMapping("/updat_crm_produit_information")
    public  ResponseEntity<ProduitDTO> update(@RequestBody ProduitDTO produitDto){
        return new ResponseEntity<>(produitService.update(produitDto),HttpStatus.OK);
    }
    //


    //
    @DeleteMapping("/delete_crm_produit_information/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        produitService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping(path = "/produit/addPDFFileToProduit/{id}")
    public String addPDFFileEmentPFE( @PathVariable  Long id, @RequestParam ("file") MultipartFile file) throws IOException {
        ProduitEntity produitEntity =produitRepository.findById(id).get();
        String encodedString = Base64.getEncoder().encodeToString(file.getBytes());
        DocumentationEntity documentationEntity = new DocumentationEntity();
        documentationEntity.setFils(file.getBytes());
        documentationEntity.setName(file.getName());
        documentationEntity.setType(file.getContentType());
        documentationEntity.setProduits(produitEntity);
        documentationRepository.save(documentationEntity);
        if(file.getBytes() != null){
            return "file stored successfully";
        }else{
            return "file doesn't stored successfully";
        }
    }

    @GetMapping(path = "/encadrements/visualisation/{id}")
    public String downloadFile(@PathVariable Long id ){
        DocumentationEntity d = documentationRepository.findById(id).get();
        byte[] getFils = FileUtils.decompressFile(d.getFils());
        String base64 = Base64.getEncoder().encodeToString(d.getFils());
        return base64;


    }


}