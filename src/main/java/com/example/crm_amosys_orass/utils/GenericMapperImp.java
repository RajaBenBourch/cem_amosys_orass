package com.example.crm_amosys_orass.utils;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class GenericMapperImp implements IGenericMapper{
    private final ModelMapper modelMapper;

    public GenericMapperImp(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

//Stream and Collection?
    @Override
    public <T, D> List<D> mapListToList(List<T> source, Class<D> target) {
        return source.stream().map(o->modelMapper.map(o,target)).collect(Collectors.toList());
    }

    @Override
    public <D> D map(Object source, Class<D> target) {
        return modelMapper.map(source,target);
    }
}
