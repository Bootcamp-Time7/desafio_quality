package com.desafio_quality.desafio_quality.service;


import com.desafio_quality.desafio_quality.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictServiceImp implements IDistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public Double propertyTotalValue() {
        return null;
    }
}
