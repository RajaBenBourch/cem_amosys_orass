package com.example.crm_amosys_orass.servise.impl;

import com.example.crm_amosys_orass.model.DocumentationEntity;
import com.example.crm_amosys_orass.model.LogoEntity;
import com.example.crm_amosys_orass.repository.DocumentationRepository;
import com.example.crm_amosys_orass.repository.LogoRepository;
import com.example.crm_amosys_orass.utils.FileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LogoService {
    @Autowired
    private LogoRepository logoRepository;
    public byte[] downloadImage(String fileName){
        Optional<LogoEntity> dbImageData = logoRepository.findByName(fileName);
        byte[] images= FileUtils.decompressFile(dbImageData.get().getFils());
        return images;
    }
}
