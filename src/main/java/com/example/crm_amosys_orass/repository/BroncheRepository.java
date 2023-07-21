package com.example.crm_amosys_orass.repository;

import com.example.crm_amosys_orass.model.BroncheEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BroncheRepository extends JpaRepository <BroncheEntity, Long>{

}
