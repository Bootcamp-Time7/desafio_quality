package com.desafio_quality.desafio_quality.service;


import com.desafio_quality.desafio_quality.model.District;
import com.desafio_quality.desafio_quality.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImp implements IDistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public Double residenceTotalValue() {
        return null;
    }

    @Override
    public List<District> findAll() {
        return districtRepository.getAllDistrict();
    }

    @Override
    public District create(District district) {
        return null;
    }

    @Override
    public District read(String districtName) {
        return districtRepository.getByName(districtName);
    }
}
