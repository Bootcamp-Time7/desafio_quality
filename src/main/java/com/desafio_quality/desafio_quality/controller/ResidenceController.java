package com.desafio_quality.desafio_quality.controller;

import com.desafio_quality.desafio_quality.model.Residence;
import com.desafio_quality.desafio_quality.model.Room;
import com.desafio_quality.desafio_quality.model.RoomDto;
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
    public ResponseEntity<List<RoomDto>> getSquareRoom(@PathVariable String residence){

      return ResponseEntity.ok(residenceService.getSquareRooms(residence));

    }

    @GetMapping("/calcTotalArea/{residenceName}")
    public ResponseEntity <Double> calculateTotalArea (@PathVariable String residenceName){
        return ResponseEntity.ok(residenceService.getTotalArea(residenceName));
    }

    @GetMapping("/calcTotalPrice/{residenceName}")
    public ResponseEntity <Double> totalPrice (@PathVariable String residenceName){
        return ResponseEntity.ok(residenceService.getTotalPrice(residenceName));
    }

    @GetMapping("/getAll")
    public ResponseEntity <List<Residence>>  findAll (){

        return ResponseEntity.ok(residenceService.findAll());
    }

    @GetMapping("/read")
    public ResponseEntity <Residence> readResidence(@RequestParam String residenceName){
        return  ResponseEntity.ok(residenceService.read(residenceName));
    }
}
