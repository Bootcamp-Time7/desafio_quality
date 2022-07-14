package com.desafio_quality.desafio_quality.controller;

import com.desafio_quality.desafio_quality.model.District;
import com.desafio_quality.desafio_quality.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/District")
public class DistrictController {

    @Autowired
    private IDistrictService districtService;

    @PostMapping ("/registerDistrict")
    public ResponseEntity<District> registerDistrict (@RequestBody District district){
        if(district.getName()!=null){
            return null;// bairo já existe"
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(districtService.create(district));
    }

}
