package com.example.crm_amosys_orass.repository;

import com.example.crm_amosys_orass.model.FactureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends JpaRepository<FactureEntity, Integer>{



}



