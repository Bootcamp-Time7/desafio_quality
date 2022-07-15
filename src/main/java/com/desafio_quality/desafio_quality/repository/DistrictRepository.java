package com.desafio_quality.desafio_quality.repository;


import com.desafio_quality.desafio_quality.model.District;
import com.desafio_quality.desafio_quality.model.Property;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Repository
public class DistrictRepository {

    private final static String districtJson = "src/main/resources/district.json";

    public List<District> getAllDistrict(){
        ObjectMapper lendoJsonDistrict = new ObjectMapper();
        List<District> listDistrict=null;


        try{
            listDistrict = Arrays.asList(lendoJsonDistrict.readValue(new File(districtJson), District[].class));
        }
        catch(Exception e ) {

        }
        return null;
    }

}
