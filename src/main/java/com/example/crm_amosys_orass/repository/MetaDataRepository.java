package com.example.crm_amosys_orass.repository;
import com.example.crm_amosys_orass.model.ClientEntity;
import com.example.crm_amosys_orass.model.MetaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface MetaDataRepository extends JpaRepository <MetaData, Long>{
}
