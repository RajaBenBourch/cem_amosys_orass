package com.example.crm_amosys_orass.config;

import com.example.crm_amosys_orass.mapper.ClientMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {
    //Beans?
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
