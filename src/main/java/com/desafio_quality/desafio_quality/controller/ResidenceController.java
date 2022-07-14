package com.desafio_quality.desafio_quality.controller;

import com.desafio_quality.desafio_quality.model.District;
import com.desafio_quality.desafio_quality.model.Residence;
import com.desafio_quality.desafio_quality.service.IResidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Residence")
public class ResidenceController {

    @Autowired
    private IResidenceService residenceService;

    @PostMapping("/registerResidence")
    public ResponseEntity<Residence> registerResidence (@RequestBody Residence residence){
//        if(residence.getResidenceName()!=null){
//            return null;// residencia já existe"
//        }
        residenceService.create(residence);
        return ResponseEntity.ok(residence);
    }

    @GetMapping("/calculateBiggestCommode/{residenceName}")
    public ResponseEntity<Residence> calculateBiggestCommode(@PathVariable  String residenceName) {
        return ResponseEntity.ok(residenceService.calculateBiggestCommode(residenceName));
    }
}
