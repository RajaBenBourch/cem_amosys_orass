package com.example.crm_amosys_orass.mapper;
import com.example.crm_amosys_orass.dto.DocumentationDTO;
import com.example.crm_amosys_orass.model.ClientEntity;
import com.example.crm_amosys_orass.model.DocumentationEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DocumentMapper extends BaseMapper<DocumentationEntity, DocumentationDTO>{
    public DocumentMapper(DocumentationEntity documentationEntity, DocumentationDTO documentationDTO) {
        super(documentationEntity, documentationDTO);
    }


    public List<DocumentationDTO> toDocumentDtos(List<DocumentationEntity> documents) {
        return documents.stream()
                .map(this::toDocumentDto)
                .collect(Collectors.toList());
    }

    public DocumentationEntity toDocument(DocumentationDTO documentationDTO){

        DocumentationEntity document = toEntity(documentationDTO);
        return document;
    }

    public DocumentationEntity toEntity(DocumentationDTO dto, ClientEntity clientEntity) {
        DocumentationEntity entity = new DocumentationEntity();
        entity.setName(dto.getName());
        entity.setType(dto.getType());
        return entity;
    }

    public DocumentationDTO toDocumentDto(DocumentationEntity document) {
        DocumentationDTO documentationDTO = new DocumentationDTO();  // Set the client ID instead of the whole client object
        documentationDTO.setName(document.getName());
        documentationDTO.setIdDocument(document.getIdDocument());
        documentationDTO.setFils(document.getFils());
        documentationDTO.setType(document.getType());

        return documentationDTO;
    }

}
