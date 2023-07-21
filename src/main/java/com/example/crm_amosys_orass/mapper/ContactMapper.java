package com.example.crm_amosys_orass.mapper;

import com.example.crm_amosys_orass.dto.ContactDTO;
import com.example.crm_amosys_orass.model.ContactEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContactMapper extends BaseMapper<ContactEntity, ContactDTO>{
    public ContactMapper(ContactEntity contact, ContactDTO contactDto) {
        super(contact, contactDto);
    }
    public List<ContactDTO> ToContactDtos(List<ContactEntity> contacts) {
        List<ContactDTO> dtos = new ArrayList<>();
        for (ContactEntity contact: contacts) {
            ContactDTO dto = toContatcDto(contact);
            dtos.add(dto);
        }
        return dtos;
    }

    public ContactEntity toContact(ContactDTO contactDTO){

        ContactEntity contact = new ContactEntity();
        contact.setIdContact(contactDTO.getIdContact());
        contact.setNom(contactDTO.getNomContact());
        contact.setFax(contactDTO.getFax());
        contact.setRole(contactDTO.getRoleContact());
        contact.setTeleFixe(contactDTO.getTelephone());
        contact.setEmail(contactDTO.getEmail());
        contact.setDateCreate(contactDTO.getDateCreate());


        return contact;
    }

    public ContactDTO toContatcDto(ContactEntity contact){
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setIdContact(contact.getIdContact());
        contactDTO.setNomContact(contact.getNom());
        contactDTO.setRoleContact(contact.getRole());
        contactDTO.setEmail(contact.getEmail());
        contactDTO.setFax(contact.getFax());
        contactDTO.setTelephone(contact.getTeleFixe());
        return contactDTO;

    }
}
