package com.desafio_quality.desafio_quality.service;

import com.desafio_quality.desafio_quality.handler.HandlerException;
import com.desafio_quality.desafio_quality.model.District;

import java.util.List;

public interface IDistrictService {

    List<District> findAll();

    District create(District district) throws HandlerException;

    District read(String districtName);

    boolean isDistrictRegistered(String districtName);
}
