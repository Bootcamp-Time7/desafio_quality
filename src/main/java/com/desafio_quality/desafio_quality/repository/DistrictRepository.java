package com.desafio_quality.desafio_quality.repository;


import com.desafio_quality.desafio_quality.model.District;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class DistrictRepository {

    private List<District> districtData = new ArrayList<>();

    public void saveDistrict (District district) {
        this.districtData.add(district);

    }

    public List<District> getAllDistrict (){
        return this.districtData;
    }


    public District getByName (String districtName) {
        District tempDistrict=null;

        for (District d : districtData) {
            if (d.getName().equals(districtName)) {
                tempDistrict = d;
            }
        }
        return tempDistrict;
    }

}
