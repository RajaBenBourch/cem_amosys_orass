package com.example.crm_amosys_orass.repository;

import com.example.crm_amosys_orass.model.ClientEntity;
import com.example.crm_amosys_orass.model.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity,Long> {
}
