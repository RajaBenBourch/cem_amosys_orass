package com.example.crm_amosys_orass.controller;

import com.example.crm_amosys_orass.dto.ClientDTO;
import com.example.crm_amosys_orass.dto.ContactDTO;
import com.example.crm_amosys_orass.servise.impl.ClientService;
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
public class ClientController {
    @Autowired
    private ClientService clientServise;
    @GetMapping("/crm_client_information")
    public ResponseEntity<List<ClientDTO>>getAllClient(){
        return new ResponseEntity<>(clientServise.getAll(),HttpStatus.OK);
    }

    //getclient
    @GetMapping("/crm_client_information/{id_client}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable long idClient){
        return new ResponseEntity<>(clientServise.getById(idClient),HttpStatus.OK);
    }

    @GetMapping("/crm_client_contact/{idClient}")
    public ResponseEntity<List<ContactDTO>> getClientContact(@PathVariable long idClient){
        return new ResponseEntity<>(clientServise.getContact(idClient),HttpStatus.OK);
    }
    //save client
    @GetMapping("/delete_crm_client_contact/{idContact}")
    public ResponseEntity<List<ContactDTO>> deleteContact(@PathVariable long idContact){
        return new ResponseEntity<>(clientServise.deleteContact(idContact),HttpStatus.OK);
    }
    @PostMapping("/create_crm_client_information")
    public ResponseEntity<List<ClientDTO>> save(@RequestBody ClientDTO client){
        System.out.println(client);
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
    @GetMapping("/delete_crm_client_information/{idClient}")
    public ResponseEntity<List<ClientDTO>> delete(@PathVariable long idClient){
        clientServise.delete(idClient);
        return new ResponseEntity<>(HttpStatus.OK);


        }

    }

