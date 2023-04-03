package com.example.crm_amosys_orass.utils;

import java.util.List;

public interface IGenericMapper {
    //class Generic
    <T,D> List<D> mapListToList(List<T> source, Class<D> target);
    <D> D map(Object source, Class<D> target);
}
