package com.desafio_quality.desafio_quality.controller;

import com.desafio_quality.desafio_quality.model.Residence;
import com.desafio_quality.desafio_quality.model.Room;
import com.desafio_quality.desafio_quality.service.IResidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/calculateBiggestCommode/{residenceName}")
    public ResponseEntity<Room> calculateBiggestCommode(@PathVariable  String residenceName) {
        return ResponseEntity.ok(residenceService.calculateBiggestRoom(residenceName));
    }

    @GetMapping("/roomSquare/{residence}")
    public ResponseEntity<List<String>> getSquareRoom(@PathVariable String residence){

      return ResponseEntity.ok(residenceService.getSquareRooms(residence));

    }
}
