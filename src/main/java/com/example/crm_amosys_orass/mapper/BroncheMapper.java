package com.example.crm_amosys_orass.mapper;
import com.example.crm_amosys_orass.dto.BroncheDto;
import com.example.crm_amosys_orass.model.BroncheEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class BroncheMapper extends BaseMapper<BroncheEntity, BroncheDto> {
    public BroncheMapper(BroncheEntity broncheEntity, BroncheDto broncheDto) {
        super(broncheEntity, broncheDto);
    }
    public BroncheEntity toBronch(BroncheDto broncheDto){

        BroncheEntity bronche= new BroncheEntity();
                bronche.setIdBronch(broncheDto.getIdBronch());
        bronche.setNomBronche(broncheDto.getNomBronche());
        return bronche;

    }

    public BroncheDto toBronchDto(BroncheEntity bronche){
        BroncheDto broncheDto = new BroncheDto();
        broncheDto.setIdBronch(bronche.getIdBronch());
        broncheDto.setNomBronche(bronche.getNomBronche());

        return broncheDto;
    }

    public List<BroncheDto> ToBronchDtos(List<BroncheEntity>bronche){
        List<BroncheDto> dtos= new ArrayList<>();
        for (BroncheEntity broncheEntity:  bronche ){
            BroncheDto dto =toBronchDto(broncheEntity);
            dtos.add(dto);
        }
        return  dtos;
    }

}
