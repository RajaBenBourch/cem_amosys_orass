package com.example.crm_amosys_orass.repository;
import com.example.crm_amosys_orass.model.EtapeEntity;
import com.example.crm_amosys_orass.model.OpportuniteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface OpportunityRepository extends JpaRepository<OpportuniteEntity, Long> {
    List<OpportuniteEntity> findByEtape(EtapeEntity etape);
    @Query("SELECT p FROM OpportuniteEntity p WHERE p.etape = ?1")
    List<OpportuniteEntity> searchOpportunities(EtapeEntity etape);
}
