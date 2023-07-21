package com.example.crm_amosys_orass.controller;

import com.example.crm_amosys_orass.dto.ContactDTO;
import com.example.crm_amosys_orass.dto.VilleDto;
import com.example.crm_amosys_orass.repository.ClientRepository;
import com.example.crm_amosys_orass.repository.CountryRepository;
import com.example.crm_amosys_orass.repository.ProduitRepository;
import com.example.crm_amosys_orass.servise.impl.ProduitClientService;
import com.example.crm_amosys_orass.servise.impl.VilleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Ville")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class VilleController {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private VilleService villeService;
    @Autowired
    private ProduitRepository produitRepository;



    @GetMapping("/crm_Country_ville/{idCountry}")
    public ResponseEntity<List<VilleDto>> getCountryVille(@PathVariable long idCountry){
        return new ResponseEntity<>(villeService.getVille(idCountry),HttpStatus.OK);
    }
    @PostMapping("/create_crm_country_ville")
    public ResponseEntity<List<VilleDto>> mergeVille(@RequestBody VilleDto villeDto){
        villeService.mergeVille(villeDto);
        return new ResponseEntity<>(villeService.getVille(villeDto.getIdCountry()), HttpStatus.OK);
    }

    @GetMapping("/delete_crm_country_ville/{idVille}")
    public ResponseEntity<List<VilleDto>> deleteVille(@PathVariable long idVille){
        return new ResponseEntity<>(villeService.deleteVille(idVille),HttpStatus.OK);
    }
}
