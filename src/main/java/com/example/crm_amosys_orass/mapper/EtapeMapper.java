package com.example.crm_amosys_orass.mapper;
import com.example.crm_amosys_orass.dto.DocumentationDTO;
import com.example.crm_amosys_orass.model.DocumentationEntity;
import org.springframework.stereotype.Component;
import com.example.crm_amosys_orass.dto.EtapeDTO;
import com.example.crm_amosys_orass.model.EtapeEntity;
import java.util.ArrayList;
import java.util.List;
@Component
public class EtapeMapper extends BaseMapper<EtapeEntity, EtapeDTO> {
    public EtapeMapper(EtapeEntity etapeEntity, EtapeDTO etapeDTO) {
        super(etapeEntity, etapeDTO);
    }
    public List<EtapeDTO> ToEtapDtos(List<EtapeEntity> etaps) {
        List<EtapeDTO> dtos = new ArrayList<>();
        for (EtapeEntity etape: etaps) {
            EtapeDTO dto = toEtapDto(etape);
            dtos.add(dto);
        }
        return dtos;
    }
    public EtapeDTO toEtapDto(EtapeEntity etape){
        EtapeDTO etapeDTO = new EtapeDTO();
        etapeDTO.setIdEtape(etape.getIdEtape());
        etapeDTO.setName(etape.getName());

        return etapeDTO;
    }
    public EtapeEntity toEtape(EtapeDTO etapeDTO){
        EtapeEntity etape = new EtapeEntity();
        etape.setIdEtape(etapeDTO.getIdEtape());
        etape.setName(etapeDTO.getName());
        return etape;
    }

    public DocumentationDTO toDTO(DocumentationEntity document) {
        return DocumentationDTO.builder()
                .id(document.getIdDocument())
                .name(document.getName())
                .type(document.getType())
                .build();
    }
}