package com.example.crm_amosys_orass.servise.impl;


import com.example.crm_amosys_orass.controller.ClientController;
import com.example.crm_amosys_orass.dto.ContactDTO;
import com.example.crm_amosys_orass.dto.VilleDto;
import com.example.crm_amosys_orass.mapper.ProduitClientMapper;
import com.example.crm_amosys_orass.mapper.VilleMapper;
import com.example.crm_amosys_orass.model.ClientEntity;
import com.example.crm_amosys_orass.model.ContactEntity;
import com.example.crm_amosys_orass.model.CountryEntity;
import com.example.crm_amosys_orass.model.VilleEntity;
import com.example.crm_amosys_orass.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VilleService {
    @Autowired
    private VilleRepository villeRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private VilleMapper villeMapper ;
    public List<VilleDto> getVille(long idCountry) {
        Optional<CountryEntity> country = countryRepository.findById(idCountry);
        List<VilleEntity> villes = country.get().getVilles();
        return villeMapper.ToVilleDtos(villes);
    }

    public void mergeVille(VilleDto villeDto) {
        CountryEntity country = countryRepository.findById(villeDto.getIdVille()).get();
        VilleEntity ville = villeMapper.toVille(villeDto);
        ville.setCountry(country);
        ville = villeRepository.save(ville);
        List<VilleEntity> villeEntities = country.getVilles();
        villeEntities.add(ville);
        country.setVilles(villeEntities);
        villeRepository.save(ville);
    }
    public List<VilleDto> deleteVille (long idVille){
        VilleEntity ville = villeRepository.findById(idVille).get();
        villeRepository.deleteById(idVille);
        return getVille(ville.getCountry().getIdCountry());
    }

}
