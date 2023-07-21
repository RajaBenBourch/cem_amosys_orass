package com.example.crm_amosys_orass.controller;
import com.example.crm_amosys_orass.dto.EtapeDTO;
import com.example.crm_amosys_orass.dto.OpportunityDTO;
import com.example.crm_amosys_orass.servise.impl.EtapeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class EtapeController {
    private EtapeService etapeService;
    @Autowired
    public EtapeController(EtapeService etapeService) {
        this.etapeService = etapeService;
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<EtapeDTO>>getAllEtap(){
        return new ResponseEntity<>(etapeService.getAll(),HttpStatus.OK);
    }
   /* @PostMapping("/Etape")
    public ResponseEntity<EtapeDTO>createEtape(@RequestBody EtapeDTO dto) {
        EtapeDTO createdDto = etapeService.createEtape(dto);
        return new ResponseEntity<>(createdDto, HttpStatus.CREATED);
    }
*/


    @PostMapping("/Etape")
    public ResponseEntity<List<EtapeDTO>> createEtape(@RequestBody EtapeDTO dto) {
        try {
            EtapeDTO createdDto = etapeService.createEtape(dto);
            return new ResponseEntity<>(etapeService.getAll(),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<EtapeDTO> getEtape(@PathVariable Long idEtape) {
        EtapeDTO dto = etapeService.getEtapeById(idEtape);
        if (dto != null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    /*  public ResponseEntity<EtapeDTO> updateEtape(@PathVariable Long idEtape, @RequestBody EtapeDTO dto) {
        EtapeDTO updatedDto = etapeService.updateEtape(idEtape, dto);
        if (updatedDto != null) {
            return new ResponseEntity<>(updatedDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/
   // @PutMapping("/update_crm_client_information")
    public  ResponseEntity<EtapeDTO> updateEtape(@RequestBody EtapeDTO client){
        return new ResponseEntity<>(etapeService.updateEtape(client),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtape(@PathVariable Long idEatpe) {
        boolean deleted = etapeService.deleteEtapeOpportunite(idEatpe);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ...

    @PostMapping("/create_crm_etape_opportuniter")
    public ResponseEntity<List<OpportunityDTO>> mergeContact(@RequestBody OpportunityDTO opportunityDTO){
        etapeService.mergeOpp(opportunityDTO);
        return new ResponseEntity<>(etapeService.getOpportunite(opportunityDTO.getIdEtape()),HttpStatus.OK);
    }
    @GetMapping("/delete_crm_etape_opportuniter/{idOpp}")
    public ResponseEntity<List<OpportunityDTO>> deleteoppurtunite(@PathVariable long idOpportuniter){
        return new ResponseEntity<>(etapeService.deleteoppurtunite(idOpportuniter), HttpStatus.OK);
    }
    @GetMapping("/crm_etape_etapeOpp/{idEtape}")
    public ResponseEntity<List<OpportunityDTO>> getOpportunite(@PathVariable long idEtape){


        return new ResponseEntity<>(etapeService.getOpportunite(idEtape),HttpStatus.OK);
    }



}
