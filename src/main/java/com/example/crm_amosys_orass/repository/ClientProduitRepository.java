package com.example.crm_amosys_orass.repository;

import com.example.crm_amosys_orass.model.ClientProduitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ClientProduitRepository extends JpaRepository<ClientProduitEntity,Long> {

}
