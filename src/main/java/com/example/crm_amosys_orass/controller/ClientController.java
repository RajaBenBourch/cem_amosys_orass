package com.example.crm_amosys_orass.controller;

import com.example.crm_amosys_orass.dto.ClientDTO;
import com.example.crm_amosys_orass.dto.ContactDTO;
import com.example.crm_amosys_orass.model.ClientEntity;
import com.example.crm_amosys_orass.servise.impl.ClientServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ClientController {
    @Autowired
    private ClientServise clientServise;
    @GetMapping("/crm_client_information")
    public ResponseEntity<List<ClientDTO>>  getAllClient(){
        return new ResponseEntity<>(clientServise.getAll(),HttpStatus.OK);
        /*********************/
        /**********************/
    }
    //getclient
    @GetMapping("/crm_client_information/{id_client}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable long id_client){
        return new ResponseEntity<>(clientServise.getById(id_client),HttpStatus.OK);
    }

    @GetMapping("/crm_client_contact/{id_client}")
    public ResponseEntity<List<ContactDTO>> getClientContact(@PathVariable long id_client){
        return new ResponseEntity<>(clientServise.getContact(id_client),HttpStatus.OK);
    }
    //save client
    @GetMapping("/delete_crm_client_contact/{id_contact}")
    public ResponseEntity<List<ContactDTO>> deleteContact(@PathVariable long id_contact){
        return new ResponseEntity<>(clientServise.deleteContact(id_contact),HttpStatus.OK);
    }
    @PostMapping("/create_crm_client_information")
    public ResponseEntity<List<ClientDTO>> save(@RequestBody ClientDTO client){
        clientServise.save(client);
        return new ResponseEntity<>(clientServise.getAll(),HttpStatus.OK);
    }
    @PostMapping("/create_crm_client_contact")
    public ResponseEntity<List<ContactDTO>> mergeContact(@RequestBody ContactDTO contact){
        clientServise.mergeContact(contact);
        return new ResponseEntity<>(clientServise.getContact(contact.getIdClient()),HttpStatus.OK);
    }
    @PutMapping("/update_crm_client_information")
    public  ResponseEntity<ClientDTO> update(@RequestBody ClientDTO client){
        return new ResponseEntity<>(clientServise.update(client),HttpStatus.OK);
    }
    //delete country
    @GetMapping("/delete_crm_client_information/{id_client}")
    public ResponseEntity<ClientDTO> delete(@PathVariable long id_client){
        clientServise.delete(id_client);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
