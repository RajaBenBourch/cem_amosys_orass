package com.example.crm_amosys_orass.controller;

import com.example.crm_amosys_orass.dto.ClientDTO;
import com.example.crm_amosys_orass.dto.CountryDTO;
import com.example.crm_amosys_orass.model.CountryEntity;
import com.example.crm_amosys_orass.repository.CountryRepository;

import com.example.crm_amosys_orass.servise.impl.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/api/V1")
@CrossOrigin(origins = "*")
public class CountryController {
   /* @Autowired
    private CountryRepository countryRepository;
    //get country
 @GetMapping("/get_crm_country_information")
    public List<CountryEntity> getAllCountry(){
        return this.countryRepository.findAll();
    }
    //get country by id
    @GetMapping("/crm_country_information/{id_country}")
    public ResponseEntity<CountryEntity> getCountryById(@PathVariable(value = "id_country") Long id_country)
            throws ResourceNotFoundException {
        CountryEntity country = countryRepository.findById(id_country)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found for this id :: " + id_country));
        return ResponseEntity.ok().body(country);
    }


    //save country
    @PostMapping("/crm_country_information")


    public CountryEntity createCountry(@RequestBody CountryEntity countryEntity) {
        return this.countryRepository.save(countryEntity);
    }

    //update country
    @PutMapping("/crm_country_information/{id_country}")
    public ResponseEntity<CountryEntity> updateCountry(@PathVariable(value = "id_country")Long id_country,
                    @Valid @RequestBody CountryEntity countryDetails)throws ResourceNotFoundException {
       CountryEntity countryEntity = countryRepository.findById(id_country)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found for this id :: " + id_country));
       countryEntity.setNom_country(countryDetails.getNom_country());
       countryEntity.setCode_postal(countryDetails.getCode_postal());
       countryEntity.setDate_creat_country(countryDetails.getDate_creat_country());

        return  ResponseEntity.ok(this.countryRepository.save(countryEntity));
    }
    //delete country
    @DeleteMapping("/crm_country_information/{id_country}")
public Map<String, Boolean> deletedCountry(@PathVariable(value = "id_country")Long id_country){
        CountryEntity countryEntity = countryRepository.findById(id_country)
     .orElseThrow(() -> new ResourceNotFoundException("Country not found for this id :: " + id_country));
this.countryRepository.delete(countryEntity);
Map<String,Boolean> response =new HashMap<>();
response.put("deleted", Boolean.TRUE);
return response;
}*/

    @Autowired
    private CountryService countryService;
    @GetMapping("/get_crm_country_information")
    public ResponseEntity<List<CountryDTO>>  getAllClient(){
        return new ResponseEntity<>(countryService.getAll(), HttpStatus.OK);
    }
    //getclient
    @GetMapping("/get_crm_country_information/{idCountry}")
    public ResponseEntity<CountryDTO> getById(@PathVariable long idCountry){
        return new ResponseEntity<>(countryService.getById(idCountry),HttpStatus.OK);
    }
    //save client

    @PostMapping("/create_crm_country_information")
    public ResponseEntity<CountryDTO> save(@RequestBody CountryDTO country){
        return new ResponseEntity<>(countryService.save(country),HttpStatus.OK);
    }
    @PutMapping("/update_crm_country_information")
    public  ResponseEntity<CountryDTO> update(@RequestBody CountryDTO country){
        return new ResponseEntity<>(countryService.update(country),HttpStatus.OK);
    }
    //delete country
    @DeleteMapping("/delete_crm_country_information/{id_client}")
    public ResponseEntity<Void> delete(@PathVariable long idCountry){
        countryService.delete(idCountry);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
