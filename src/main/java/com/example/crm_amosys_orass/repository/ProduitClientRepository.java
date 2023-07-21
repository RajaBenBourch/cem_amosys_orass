package com.example.crm_amosys_orass.repository;

import com.example.crm_amosys_orass.model.ClientEntity;
import com.example.crm_amosys_orass.model.ProduitClientEntity;
import com.example.crm_amosys_orass.model.ProduitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitClientRepository extends JpaRepository<ProduitClientEntity, Long> {
    List<ProduitEntity> findByClient(ClientEntity client);

}
