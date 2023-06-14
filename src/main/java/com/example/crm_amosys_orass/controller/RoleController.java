package com.example.crm_amosys_orass.controller;
import com.example.crm_amosys_orass.dto.RoleDto;
import com.example.crm_amosys_orass.repository.ClientRepository;
import com.example.crm_amosys_orass.servise.impl.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RequiredArgsConstructor
public class RoleController {

    @Autowired
    private RoleService roleService;


    @GetMapping("/crm_Role")

    public ResponseEntity<List<RoleDto>> getAllRoll(){

        return new ResponseEntity<>(roleService.getAll(),HttpStatus.OK);

    }
    @PostMapping("/creat_crm_Role")
    public ResponseEntity<List<RoleDto>> save(@RequestBody RoleDto roleDto){
        System.out.println(roleDto);
        roleService.save(roleDto);
        return new ResponseEntity<> (roleService.getAll(),HttpStatus.OK);

    }

}
