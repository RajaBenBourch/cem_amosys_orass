package com.example.crm_amosys_orass.servise.impl;
import com.example.crm_amosys_orass.dto.RoleDto;
import com.example.crm_amosys_orass.mapper.RoleMapper;
import com.example.crm_amosys_orass.model.RoleEntity;
import com.example.crm_amosys_orass.repository.RoleRepository;
import com.example.crm_amosys_orass.utils.IGenericMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private IGenericMapper iGenericMapper;
    public List<RoleDto> getAll() {
        List<RoleEntity> roles = roleRepository.findAll();
        return roleMapper.ToRoleDtos(roles);
    }
    public void save(RoleDto roleDto){

        RoleEntity roleEntity =roleMapper.toRole(roleDto);
        roleRepository.save(roleEntity);

    }

}
