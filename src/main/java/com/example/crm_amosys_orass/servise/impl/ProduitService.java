package com.example.crm_amosys_orass.servise.impl;
import com.example.crm_amosys_orass.dto.ProduitDTO;
import com.example.crm_amosys_orass.mapper.ProduitMapper;
import com.example.crm_amosys_orass.model.ProduitEntity;
import com.example.crm_amosys_orass.repository.ProduitRepository;
import com.example.crm_amosys_orass.utils.IGenericMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ProduitService{    /************/
@Autowired
private ProduitRepository produitRepository;
    @Autowired
    private ProduitMapper produitMapper;
    @Autowired
    private IGenericMapper iGenericMapper;

    public void save(ProduitDTO produitDTO){

            ProduitEntity produitEntity = produitMapper.toProduit(produitDTO);
            produitRepository.save(produitEntity);

        //return iGenericMapper.map(clientRepository.save(iGenericMapper.map(client, ClientEntity.class)),ClientDTO.class);
    }
    //@Transactional

  //
    // public int delete(String ref) {
        //return produitRepository.deleteByRef(ref);
  //  }


    public ProduitDTO update(ProduitDTO produitDto) {
        Optional<ProduitEntity> produitEntity = produitRepository.findById(produitDto.getId());
        if (produitEntity.isEmpty()) return null;
        update(produitEntity.get(), produitDto);
        ProduitEntity saved = produitRepository.save(produitEntity.get());
        return iGenericMapper.map(saved, ProduitDTO.class);
    }
    //
   /* public ProduitDTO update(ProduitDTO produit){
        Optional<ProduitEntity> emp = this.produitRepository.findById(produit.idProduit());
        if (emp.isEmpty()){
            throw new ResourceNotFoundException("Country not found for this id ");
        }

        return iGenericMapper.map(produitRepository.save(iGenericMapper.map(produit, ProduitEntity.class)),ProduitDTO.class);
    }*/
    //

    private void update(ProduitEntity produitEntity, ProduitDTO produitDto) {
        produitEntity.setLibelle(produitDto.getLibelle());
    }


    public ProduitDTO findProduitEntitiesById(Long id) {
        ProduitEntity produitEntity = produitRepository.findProduitEntitiesById(id);
        if (produitEntity == null) return null;
        return iGenericMapper.map(produitEntity, ProduitDTO.class);
    }




    //Git All produit
    public List<ProduitDTO> findAll() {
        List<ProduitEntity> produits = produitRepository.findAll();
        return produitMapper.ToProduitDtos(produits);
    }
    public void  delete(Long id){
        this.produitRepository.deleteById(id);
    }


}