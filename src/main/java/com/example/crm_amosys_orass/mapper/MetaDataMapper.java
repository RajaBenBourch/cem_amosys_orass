package com.example.crm_amosys_orass.mapper;
import com.example.crm_amosys_orass.dto.ContactDTO;
import com.example.crm_amosys_orass.dto.MetaDataDto;
import com.example.crm_amosys_orass.model.ContactEntity;
import com.example.crm_amosys_orass.model.MetaData;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class MetaDataMapper extends BaseMapper<MetaData, MetaDataDto>{
    public MetaDataMapper(MetaData metaData, MetaDataDto metaDataDto) {
        super(metaData, metaDataDto);
    }
    public MetaDataDto toMetaDataDto(MetaData metaData){
        MetaDataDto metaDataDto = new MetaDataDto();
        metaDataDto.setIdMeta(metaData.getIdMeta());
        metaDataDto.setEmail(metaData.getEmail());
        metaDataDto.setLagrement(metaData.getLagrement());
        metaDataDto.setIdentifiantfiscal(metaData.getIdentifiantfiscal());
        metaDataDto.setTeleFixe(metaData.getTeleFixe());
        metaData.setClient(metaData.getClient().getLogo().getClient());
        metaDataDto.setTimeZone(metaDataDto.getTimeZone());
       metaDataDto.setTypeActivite(metaDataDto.getTypeActivite());
        return metaDataDto;
    }
    public List<MetaDataDto> ToMetaDataDtos(List<MetaData> metaDatas) {
        List<MetaDataDto> dtos = new ArrayList<>();
        for (MetaData metaData: metaDatas) {
            MetaDataDto dto = toMetaDataDto(metaData);
            dtos.add(dto);
        }
        return dtos;
    }
 /*   public  MetaData toMetaData(MetaDataDto metaDataDto){
        MetaData metaData= toEntity(metaDataDto) ;
        return metaData;
    }*/



    public MetaData toMetaData(MetaDataDto metaDataDto){
        MetaData metaData = new MetaData();
        metaData.setIdMeta(metaDataDto.getIdMeta());
        metaData.setEmail(metaDataDto.getEmail());
        metaData.setLagrement(metaDataDto.getLagrement());
        metaData.setIdentifiantfiscal(metaDataDto.getIdentifiantfiscal());
        metaData.setTeleFixe(metaDataDto.getTeleFixe());
        metaData.setClient(metaData.getClient().getLogo().getClient());
        metaData.setTimeZone(metaData.getTimeZone());
        metaData.setTypeActivite(metaData.getTypeActivite());
        return metaData;


    }
}
