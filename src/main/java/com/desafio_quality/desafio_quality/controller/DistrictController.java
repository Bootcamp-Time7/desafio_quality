package com.desafio_quality.desafio_quality.controller;

import com.desafio_quality.desafio_quality.handler.HandlerException;
import com.desafio_quality.desafio_quality.model.District;
import com.desafio_quality.desafio_quality.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/District")
public class DistrictController {

    @Autowired
    private IDistrictService districtService;

    @PostMapping ("/registerDistrict")
    public ResponseEntity<District> registerDistrict (@RequestBody @Valid District district) throws HandlerException {

        districtService.create(district);
        return ResponseEntity.ok(district);
    }

    @GetMapping("/getAll")
    public ResponseEntity <List<District>>  findAll (){

        return ResponseEntity.ok(districtService.findAll());
    }
}
