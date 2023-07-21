package com.example.crm_amosys_orass.mapper;
import org.springframework.beans.BeanUtils;
public class BaseMapper<Entity, DTO> {
    private final Entity entity;
    private final DTO dto;
    public BaseMapper(Entity entity, DTO dto) {
        this.entity = entity;
        this.dto = dto;
    }
    Entity createEntity() throws InstantiationException, IllegalAccessException {
        return entity;
    }
    DTO createDTO() throws InstantiationException, IllegalAccessException {
        return dto;
    }
    public Entity toEntity(DTO dto) {
        Entity entity = null;
        try {
            entity = createEntity();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
    public DTO toDTO(Entity entity) {
        DTO dto = null;
        try {
            dto = createDTO();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}