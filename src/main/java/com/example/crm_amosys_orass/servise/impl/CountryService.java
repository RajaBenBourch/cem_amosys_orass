package com.example.crm_amosys_orass.servise.impl;

import com.example.crm_amosys_orass.dto.CountryDTO;
import com.example.crm_amosys_orass.model.CountryEntity;
import com.example.crm_amosys_orass.repository.CountryRepository;
import com.example.crm_amosys_orass.utils.IGenericMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CountryService  {
    @Autowired

    private CountryRepository countryRepository;
    @Autowired
    private IGenericMapper iGenericMapper;


    public CountryDTO getById(Long idCountry) {

        Optional<CountryEntity> emp = this.countryRepository.findById(idCountry);
        if (emp.isEmpty()){
            throw new ResourceNotFoundException("Country not found for this id ");
        }
        return iGenericMapper.map(emp.get(),CountryDTO.class);

    }


    public List<CountryDTO> getAll() {
        return iGenericMapper.mapListToList(this.countryRepository.findAll(),CountryDTO.class);

    }


    public CountryDTO save(CountryDTO country) {
        return iGenericMapper.map(countryRepository.save(iGenericMapper.map(country, CountryEntity.class)),CountryDTO.class);    }


    public CountryDTO update(CountryDTO country) {


        return null;
    }


    public void delete(long idCountry) {
        this.countryRepository.deleteById(idCountry);
    }



}
