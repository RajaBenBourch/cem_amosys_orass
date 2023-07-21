package com.example.crm_amosys_orass.servise.impl;
import  com.example.crm_amosys_orass.dto.ClientDTO;
import  com.example.crm_amosys_orass.dto.MetaDataDto;
import  com.example.crm_amosys_orass.mapper.ClientMapper;
import  com.example.crm_amosys_orass.mapper.MetaDataMapper;
import  com.example.crm_amosys_orass.model.ClientEntity;
import  com.example.crm_amosys_orass.model.MetaData;
import  com.example.crm_amosys_orass.repository.ClientRepository;
import  com.example.crm_amosys_orass.repository.MetaDataRepository;
import  org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.stereotype.Service;
import  java.util.List;
import  java.util.Optional;
@Service
public class MetaDataService {
    @Autowired
    private MetaDataMapper  metaDataMapper;
    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private MetaDataRepository metaDataRepository;
    public List<MetaDataDto> getMetaData(long idClient) {
        Optional<ClientEntity> client = clientRepository.findById(idClient);
        List<MetaData> metaData= client.get().getMetaData();
        ClientDTO clientDTO = clientMapper.toClientDto(client.get());
        return metaDataMapper.ToMetaDataDtos(metaData);
    }
   /* public List<MetaDataDto> getMetaData(long idClient) {
        Optional<ClientEntity> client = clientRepository.findById(idClient);
        List<MetaData> metaData = client.get().getMetaData();
        // Mapper les métadonnées en utilisant metaDataMapper
        List<MetaDataDto> metaDataDtoList = metaDataMapper.ToMetaDataDtos(metaData);

        // Définir le logo du client dans chaque objet MetaDataDto
        for (MetaDataDto metaDataDto : metaDataDtoList) {
            metaDataDto.setLogo(client.get().getLogo());
        }

        return metaDataDtoList;
    }*/
    public void mergeMetaData(MetaDataDto metaDataDto) {

        ClientEntity client = clientRepository.findById(metaDataDto.getIdClient()).get();
        MetaData metaData = metaDataMapper.toMetaData(metaDataDto);
        metaData.setClient(client);
        metaData = metaDataRepository.save(metaData);
        List<MetaData> metaDataList = client.getMetaData();
        metaDataList.add(metaData);
        client.setMetaData(metaDataList);
        clientRepository.save(client);

    }


}
