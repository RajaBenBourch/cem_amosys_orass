package com.example.crm_amosys_orass.repository;

import com.example.crm_amosys_orass.model.ProduitEntity;
import com.example.crm_amosys_orass.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {


}
