package com.example.crm_amosys_orass.repository;
import com.example.crm_amosys_orass.model.ClientEntity;
import com.example.crm_amosys_orass.model.ProduitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
@Repository
public interface ProduitRepository  extends JpaRepository<ProduitEntity, Long> {
    @RestResource(path = "byId/{id}")
    public ProduitEntity findProduitEntitiesById(@PathVariable("id") Long id );
    // Optional<ProduitEntity> findByRef(String ref);
    List<ProduitEntity>findByNameContaining(String name);
    // Optional<ProduitEntity> findByLibelle(String libelle);
    //Optional<ProduitEntity> findByName(String name);
    //Optional<ProduitEntity> findByChefProduit(String chefProduit);
   // Optional<ProduitEntity> findByStatu(String statu);
   // List<ProduitEntity> findByPrixGreaterThan(BigDecimal value);
    // int deleteByRef(String ref);
 //Optional<ProduitEntity> findById(Long idProduit);

}
