package com.example.crm_amosys_orass.mapper;
import com.example.crm_amosys_orass.dto.ClientDTO;
import com.example.crm_amosys_orass.dto.VilleDto;
import com.example.crm_amosys_orass.model.ClientEntity;
import com.example.crm_amosys_orass.model.VilleEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class VilleMapper  extends BaseMapper<VilleEntity, VilleDto>{

    public VilleMapper(VilleEntity villeEntity, VilleDto villeDto) {
        super(villeEntity, villeDto);
    }

    public List<VilleDto> ToVilleDtos(List<VilleEntity> villes) {
        List<VilleDto> dtos = new ArrayList<>();
        for (VilleEntity ville: villes) {
            VilleDto dto = toVilleDto(ville);
            dtos.add(dto);
        }
        return dtos;
    }





    public VilleEntity toVille(VilleDto villeDto){

        VilleEntity ville = toEntity(villeDto);
        return ville;
    }

   /* public VilleDto toVilleDto(VilleEntity ville){
        VilleDto villeDto = new VilleDto();
        villeDto.setIdVille(ville.getIdVille());
        villeDto.setVille(ville.getVille());
        villeDto.setCodePostal(ville.getCodePostal());
        villeDto.setDateCreation(ville.getDateCreation());
        return villeDto;

    }*/

    public VilleDto toVilleDto(VilleEntity ville) {
        ModelMapper modelMapper = new ModelMapper();
        VilleDto villeDto = modelMapper.map(ville, VilleDto.class);
        return villeDto;
    }

}






