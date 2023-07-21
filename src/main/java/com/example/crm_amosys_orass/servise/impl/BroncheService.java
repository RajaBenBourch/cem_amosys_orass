package com.example.crm_amosys_orass.servise.impl;
import com.example.crm_amosys_orass.dto.BroncheDto;
import com.example.crm_amosys_orass.mapper.BroncheMapper;
import com.example.crm_amosys_orass.model.BroncheEntity;
import com.example.crm_amosys_orass.repository.BroncheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class BroncheService {
    @Autowired
    private BroncheRepository broncheRepository;
    @Autowired
    private BroncheMapper broncheMapper;
    public List<BroncheDto> getAll() {
        List<BroncheEntity> bronche = broncheRepository.findAll();
        return broncheMapper.ToBronchDtos(bronche);
    }
}
