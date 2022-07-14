package com.desafio_quality.desafio_quality.service;


import com.desafio_quality.desafio_quality.model.District;
import com.desafio_quality.desafio_quality.model.Residence;
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
        if(!verifyIfDistrictExists(district.getName())){
            districtRepository.saveDistrict(district);
        }
        return this.returnDistrict(district);
    }

    public District returnDistrict (District district) {
        return district;
    }

    @Override
    public District read(String districtName) {
        return districtRepository.getByName(districtName);
    }


    public boolean verifyIfDistrictExists (String districtName){

        for(District d :districtRepository.getListDistrict()){
            if (districtName.equals(d.getName())){

                System.out.println("erro");
                // TODO throw new Exception("erro")
            }
        }
        return false;
    }
}
