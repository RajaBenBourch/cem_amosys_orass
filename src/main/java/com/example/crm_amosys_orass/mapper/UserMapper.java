package com.example.crm_amosys_orass.mapper;
import com.example.crm_amosys_orass.dto.UserDto;
import com.example.crm_amosys_orass.model.UserEntity;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class UserMapper extends BaseMapper<UserEntity,UserDto> {
    public UserMapper(UserEntity userEntity, UserDto userDto) {
        super(userEntity, userDto);
    }
    public UserEntity toUser(UserDto userDto){
        UserEntity user = new UserEntity();
        user.setIdUser(userDto.getIdUser());
        user.setNom(userDto.getNom());
        user.setPrenom(userDto.getPrenom());
        user.setCni(userDto.getCni());
        return user;
    }

    public UserDto toUserDto(UserEntity user){
        UserDto userDto = new UserDto();
        userDto.setIdUser(user.getIdUser());
        userDto.setNom(user.getNom());
        userDto.setPrenom(user.getPrenom());
        userDto.setCni(user.getCni());
        return userDto;
    }

    public List<UserDto> ToUserDtos(List<UserEntity>users){
        List<UserDto> dtos= new ArrayList<>();
        for (UserEntity user:  users ){
            UserDto dto =toUserDto(user);
            dtos.add(dto);
        }
        return  dtos;
    }

}
