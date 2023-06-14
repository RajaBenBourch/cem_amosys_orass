package com.example.crm_amosys_orass.controller;

import com.example.crm_amosys_orass.dto.RoleDto;
import com.example.crm_amosys_orass.dto.UserDto;
import com.example.crm_amosys_orass.mapper.UserMapper;
import com.example.crm_amosys_orass.model.UserEntity;
import com.example.crm_amosys_orass.servise.impl.RoleService;
import com.example.crm_amosys_orass.servise.impl.UserService;
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
public class UserController {

    @Autowired

    private UserService userService;

    @Autowired
    private UserMapper userMapper;
    @GetMapping("/crm_user")

    public ResponseEntity<List<UserDto>> getAllRoll(){

        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);

    }

    @PostMapping("/creat_crm_user")
    public ResponseEntity<List<UserDto>> save(@RequestBody UserDto userDto){
        System.out.println(userDto);
        userService.save(userDto);
        return new ResponseEntity<> (userService.getAll(),HttpStatus.OK);

    }



    /*
    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto) {
        try {
            UserDto registeredUser = userService.registerUser(userDto);
            return ResponseEntity.ok(registeredUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }*/



}
