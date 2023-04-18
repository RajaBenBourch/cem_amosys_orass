package com.example.crm_amosys_orass.repository;

import com.example.crm_amosys_orass.model.LigneFactureEntity;
import com.example.crm_amosys_orass.model.LigneFactureKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneFactureRepository extends JpaRepository<LigneFactureEntity, LigneFactureKey> {
}
