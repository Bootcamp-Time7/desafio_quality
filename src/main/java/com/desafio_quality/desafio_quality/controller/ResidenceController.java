package com.desafio_quality.desafio_quality.controller;

import com.desafio_quality.desafio_quality.model.District;
import com.desafio_quality.desafio_quality.model.Residence;
import com.desafio_quality.desafio_quality.service.IResidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Residence")
public class ResidenceController {

    @Autowired
    private IResidenceService residenceService;

    @PostMapping("/registerResidence")
    public ResponseEntity<Residence> registerResidence (@RequestBody Residence residence){

        residenceService.create(residence);
        return ResponseEntity.ok(residence);
    }
}
