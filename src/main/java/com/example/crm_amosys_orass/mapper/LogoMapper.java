package com.example.crm_amosys_orass.mapper;

import com.example.crm_amosys_orass.dto.LogoDto;

import com.example.crm_amosys_orass.model.LogoEntity;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class LogoMapper extends BaseMapper<LogoEntity, LogoDto>{
    public LogoMapper(LogoEntity logoEntity, LogoDto logoDto) {
        super(logoEntity, logoDto);
    }
    public List<LogoDto> toLogoDtos(List<LogoEntity> logos) {
        return logos.stream()
                .map(this::toLogoDto)
                .collect(Collectors.toList());
    }
    public LogoEntity toLogo(LogoDto logoDto){
        LogoEntity logo = toEntity(logoDto);
        return logo;
    }

    public LogoEntity toEntity(LogoDto dto, LogoEntity logoEntity) {
        LogoEntity entity = new LogoEntity();
        entity.setName(dto.getName());
        entity.setType(dto.getType());
        //facultatif//
        entity.setFils(dto.getFils());
        return entity;
    }
    public LogoDto toLogoDto(LogoEntity logo) {
        LogoDto logoDto=new LogoDto();
        logoDto.setName(logo.getName());
        logoDto.setIdLogo(logo.getIdLogo());
        logoDto.setFils(logo.getFils());
        logoDto.setType(logo.getType());
        return logoDto;
    }
}
