package com.example.crm_amosys_orass.controller;

import com.example.crm_amosys_orass.dto.*;
import com.example.crm_amosys_orass.mapper.OpportunityMapper;
import com.example.crm_amosys_orass.model.*;
import com.example.crm_amosys_orass.servise.impl.OpportunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/opportunities")
@RequiredArgsConstructor
public class OpportunityController {
    @Autowired
    private OpportunityService opportunityService;
    @Autowired
    private OpportunityMapper opportunityMapper;
    @PostMapping
    public ResponseEntity<OpportunityDTO> createOpportunity(@RequestBody OpportunityDTO opportunityDto) {
        OpportunityDTO createdOpportunity = opportunityService.createOpportunity(opportunityDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOpportunity);
    }
    /******@GetMapping
    public ResponseEntity<List<OpportunityDTO>> getAllOpportunities() {


        List<OpportunityDTO> opportunities = opportunityService.getAllOpportunities();
        return ResponseEntity.ok(opportunities);
    }****/
    //
    @GetMapping
    public ResponseEntity<List<OpportunityDTO>> getAllOpportunities() {
        List<OpportunityDTO> opportunities = opportunityService.getAllOpportunities();

        /*for (OpportunityDTO opportunity : opportunities) {
            List<ProduitDTO> produits = opportunity.getProduits();

            if (produits != null) {
                StringBuilder concatenatedNames = new StringBuilder();
                for (ProduitDTO product : produits) {
                    concatenatedNames.append(product.getName()).append(", ");
                }

                if (concatenatedNames.length() > 2) {
                    concatenatedNames.setLength(concatenatedNames.length() - 2);
                }

                opportunity.setConcatenatedProducts(concatenatedNames.toString());
            } else {
                opportunity.setConcatenatedProducts("No products available");
            }
        }*/

        return ResponseEntity.ok(opportunities);
    }
    //

    @GetMapping("/opp/{opportunityId}")
    public ResponseEntity<OpportunityDTO> getOpportunityWithProducts(@PathVariable Long opportunityId) {
        OpportuniteEntity opportunity = opportunityService.getOpportunity(opportunityId);
        OpportunityDTO opportunityDTO = opportunityMapper.toDto(opportunity);

        List<ProduitOpportuniterEntity> products = opportunity.getProduits();
        /*List<ProduitDTO> productDTOs = products.stream()
                .map(ProduitMapper::toProduitDTO)
                .collect(Collectors.toSet()).stream().toList();*/

        //opportunityDTO.setProduits(productDTOs);

        return ResponseEntity.ok(opportunityDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OpportunityDTO> getOpportunityById(@PathVariable Long id) {
        OpportunityDTO opportunity = opportunityService.getOpportunityById(id);
        return ResponseEntity.ok(opportunity);
    }
    @PutMapping("/{id}")
    public ResponseEntity<OpportunityDTO> updateOpportunity(@PathVariable Long id, @RequestBody OpportunityDTO opportunityDto) {
        OpportunityDTO updatedOpportunity = opportunityService.getOpportunityById(id);
        return ResponseEntity.ok(updatedOpportunity);
    }
   /*@DeleteMapping("/{idOpportunity}")
    public ResponseEntity<List<OpportunityDTO>>deleteOpportunity(@PathVariable Long idOpportunity) {
       return new ResponseEntity<>(opportunityService.deleteOpportunityById(idOpportunity),HttpStatus.OK);
    }*/



    @DeleteMapping("/{idOpportunity}")
    public ResponseEntity<Void> delete(@PathVariable Long idOpportunity){
        opportunityService.delete(idOpportunity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/crm_opportuniter_etape/{idOpportuniter}")
    public ResponseEntity<List<EtapeDTO>> getOpportuniterEtape(@PathVariable long idOpportuniter){


        return new ResponseEntity<>(opportunityService.getEtape(idOpportuniter),HttpStatus.OK);

    }

    @PostMapping (path = "update-etape-opportunity")
    public List<OpportunityDTO> save (@RequestBody OpportunityDTO achat){
     /*ClientEntity client = clientRepository.findClientEntityByIdClient(achat.getIdClient());
        ProduitEntity p = produitRepository.findProduitEntitiesById(achat.getId());
        ProduitClientEntity produitClientEntity = new ProduitClientEntity();
        produitClientEntity.setClient(client);
        produitClientEntity.setProduit(p);
        produitClientEntity.setDateAchatP(new Date());
        produitClientEntity.setPrixAchatProduit(achat.getPrixAchatProduit());
        produitClientEntityRepository.save(produitClientEntity);*/
        int i = 0;
        int j = 0;
        System.out.println(i+j);
        return  opportunityService.getAll();
    }


  @PostMapping("/create_etape_opprtuniter")
    public ResponseEntity<List<OpportunityDTO>> saveEtap (@RequestBody OpportunityDTO opportunityDTO){
        System.out.println(opportunityDTO);
        opportunityService.save(opportunityDTO);
        return new ResponseEntity<>(opportunityService.getAll(),HttpStatus.OK);
    }

}












