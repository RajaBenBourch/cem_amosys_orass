package com.example.crm_amosys_orass.repository;

import com.example.crm_amosys_orass.model.ClientEntity;
import com.example.crm_amosys_orass.model.DocumentationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public interface DocumentationRepository extends JpaRepository<DocumentationEntity,Long> {
    Optional<DocumentationEntity> findByName(String fileName);
    //List<DocumentationEntity> findByClient(ClientEntity client);

}
