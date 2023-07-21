package com.example.crm_amosys_orass.repository;
import com.example.crm_amosys_orass.dto.ClientDTO;
import com.example.crm_amosys_orass.model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity,Long> {
    
    //ClientEntity findByNom(String nom);
    Optional<ClientEntity> findByCodeClient(String code_Client);
    public List<ClientEntity> findAllByOrderByIdClientAsc();
    //List<ClientEntity>findByNameContaining(String entreprisePrincipal);
    @RestResource(path = "byId/{id}")
    public ClientEntity findClientEntityByIdClient(@PathVariable("id") Long id );

   @Query("SELECT p FROM ClientEntity p WHERE p.entreprisePrincipal LIKE %?1%")
    List<ClientEntity> searchClients(String keyword);



  //  List<ClientEntity> findByEntreprisePrincipal(String keyword);
   // List<ClientEntity> findByNomPrenom(String keyword);



    //@Query("SELECT p FROM ClientEntity p WHERE CONCAT(p.entreprisePrincipal, ' ', p.country, ' ', p.codeClient) LIKE %?1%")
    //List<ClientEntity> searchClients(String keyword);
}
