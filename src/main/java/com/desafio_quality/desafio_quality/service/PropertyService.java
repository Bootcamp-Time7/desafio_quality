package com.desafio_quality.desafio_quality.service;

import com.desafio_quality.desafio_quality.model.Property;
import com.desafio_quality.desafio_quality.model.Room;
import com.desafio_quality.desafio_quality.repository.DistrictRepository;
import com.desafio_quality.desafio_quality.repository.PropertyRepository;
import com.desafio_quality.desafio_quality.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService implements IPropertyService{

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private RoomRepository roomRepository;


    @Override
    public Room majorRoom(Property property) {
        return null;
    }

    @Override
    public Double squareProperty(Property property) {
        return null;
    }
}
