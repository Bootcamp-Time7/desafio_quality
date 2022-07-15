package com.desafio_quality.desafio_quality.service;

import com.desafio_quality.desafio_quality.model.District;
import com.desafio_quality.desafio_quality.model.Residence;

import java.util.List;

public interface IDistrictService {

    List<District> findAll();

    void create(District district) throws Exception;

    District read(String districtName);

    public boolean verifyIfDistrictExists (String districtName);
}
