package com.example.crm_amosys_orass.repository;

import com.example.crm_amosys_orass.model.ClientEntity;
import com.example.crm_amosys_orass.model.DocumentationEntity;
import com.example.crm_amosys_orass.model.LogoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface LogoRepository extends JpaRepository<LogoEntity,Long> {
    Optional<LogoEntity> findByName(String fileName);
    //List<DocumentationEntity> findByClient(ClientEntity client);
}
