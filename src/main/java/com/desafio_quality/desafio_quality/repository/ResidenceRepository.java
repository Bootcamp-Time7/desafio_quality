package com.desafio_quality.desafio_quality.repository;


import com.desafio_quality.desafio_quality.model.Residence;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ResidenceRepository {

    private List<Residence> residenceData = new ArrayList<>();

    public List<Residence> getListResidence () {
        return residenceData;
    }

    public void saveResidence (Residence residence) {
        this.residenceData.add(residence);

    }

    public List<Residence> getAllResidence (){

        return this.residenceData;
    }


    public Residence getByName (String residenceName) {

        Residence tempResidence=null;

        for (Residence p : residenceData) {
            if (p.getResidenceName().equals(residenceName)) {
                tempResidence = p;
            }
        }

        return tempResidence;
    }


}
