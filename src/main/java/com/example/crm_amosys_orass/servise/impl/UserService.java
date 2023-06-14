package com.example.crm_amosys_orass.servise.impl;
import com.example.crm_amosys_orass.dto.UserDto;
import com.example.crm_amosys_orass.mapper.UserMapper;
import com.example.crm_amosys_orass.model.UserEntity;
import com.example.crm_amosys_orass.repository.UserRepository;
import com.example.crm_amosys_orass.utils.IGenericMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IGenericMapper iGenericMapper;

    public List<UserDto> getAll() {
        List<UserEntity> users = userRepository.findAll();
        return userMapper.ToUserDtos(users);
    }
    public void save(UserDto userDto){
        UserEntity userEntity=userMapper.toUser(userDto);
        userRepository.save(userEntity);
    }
///*************************regester*******************************//
/*
    public UserDto registerUser(UserDto userDto) {
        // Check if the username is already taken
        if (userRepository.findByUsername(userDto.getNom()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }

        // Check if the email is already registered
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already registered");
        }

        UserEntity userEntity = new UserMapper().toEntity(userDto);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userRepository.save(userEntity);

        return new UserMapper().toDTO(userEntity);
    }
//******************************************************************************/

}
