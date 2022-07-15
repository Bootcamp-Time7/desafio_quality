package com.desafio_quality.desafio_quality.service;


import com.desafio_quality.desafio_quality.excepiton.ElementAlreadyExistsException;
import com.desafio_quality.desafio_quality.model.District;
import com.desafio_quality.desafio_quality.repository.DistrictRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictServiceImp implements IDistrictService {


    private DistrictRepository districtRepository;

    public DistrictServiceImp(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    @Override
    public List<District> findAll() {
        return districtRepository.getAllDistrict();
    }

    @Override
    public District create(District district) {
    if (isDistrictRegistered(district.getName())) {
            throw new ElementAlreadyExistsException();
        }
        return  districtRepository.saveDistrict(district);
    }

    @Override
    public District read(String districtName) {
        return districtRepository.getByName(districtName);
    }

    public boolean isDistrictRegistered(String districtName)  {
       return Optional.ofNullable(districtRepository.getByName(districtName)).isPresent();
    }
}
