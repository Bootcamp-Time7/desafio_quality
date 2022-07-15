package com.desafio_quality.desafio_quality.service;


import com.desafio_quality.desafio_quality.model.District;
import com.desafio_quality.desafio_quality.model.Residence;
import com.desafio_quality.desafio_quality.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        List<District> tempDistrictList = findAll();
        boolean found = false;
        for (District r : tempDistrictList){
            if(r.getName().equalsIgnoreCase(district.getName())) {
                found = true;
                System.out.print("esse elemento ja existe"); // TODO Throw New Exception
            }
        }
        if (!found){
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

        for(District d :districtRepository.getAllDistrict()){
            if (districtName.equals(d.getName())){

                System.out.println("erro");
                // TODO throw new Exception("erro")
            }
        }
        return false;
    }
}
