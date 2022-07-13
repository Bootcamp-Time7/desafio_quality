package com.desafio_quality.desafio_quality.controller;

import com.desafio_quality.desafio_quality.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/District")
public class DistrictController {

    @Autowired
    private IDistrictService districtService;


}
