package com.example.crm_amosys_orass.mapper;
import com.example.crm_amosys_orass.dto.RoleDto;
import com.example.crm_amosys_orass.model.RoleEntity;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component

public class RoleMapper extends BaseMapper<RoleEntity, RoleDto> {
    public RoleMapper(RoleEntity roleEntity, RoleDto roleDto) {
        super(roleEntity, roleDto);
    }

    public RoleEntity toRole(RoleDto roleDto){
        RoleEntity role = new RoleEntity();
        role.setIdRole(roleDto.getIdRole());
        role.setNom(roleDto.getNom());
        return role;
    }

    public RoleDto toRoleDto(RoleEntity role){
        RoleDto roleDto = new RoleDto();
        roleDto.setIdRole(role.getIdRole());
        roleDto.setNom(role.getNom());
        return roleDto;
    }

    public List<RoleDto>ToRoleDtos(List<RoleEntity>roles){
        List<RoleDto> dtos= new ArrayList<>();
        for (RoleEntity role: roles){
        RoleDto dto =toRoleDto(role);
            dtos.add(dto);
        }
        return  dtos;
    }

}
