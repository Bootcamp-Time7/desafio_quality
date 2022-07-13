package com.desafio_quality.desafio_quality.service;


import com.desafio_quality.desafio_quality.model.Property;
import com.desafio_quality.desafio_quality.model.Room;

public interface IPropertyService {

    Room majorRoom (Property property);

    Double squareProperty (Property property); //soma das areas de todos os comodos
}
