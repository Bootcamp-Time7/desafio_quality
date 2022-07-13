package com.desafio_quality.desafio_quality.controller;

import com.desafio_quality.desafio_quality.service.IDistrictService;
import com.desafio_quality.desafio_quality.service.IPropertyService;
import com.desafio_quality.desafio_quality.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Property")
public class PropertyController {

    @Autowired
    private IPropertyService propertyService;


}
