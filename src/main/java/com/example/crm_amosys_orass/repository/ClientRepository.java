package com.example.crm_amosys_orass.repository;

import com.example.crm_amosys_orass.model.ClientEntity;
import com.example.crm_amosys_orass.model.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity,Long> {
    //ClientEntity findByNom(String nom);
    Optional<ClientEntity> findByCodeClient(String code_Client);
    public List<ClientEntity> findAllByOrderByIdClientAsc();
}
