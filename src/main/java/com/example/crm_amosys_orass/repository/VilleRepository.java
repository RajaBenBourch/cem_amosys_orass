package com.example.crm_amosys_orass.repository;
import com.example.crm_amosys_orass.model.VilleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleRepository extends JpaRepository<VilleEntity, Long> {
}
