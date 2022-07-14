package com.desafio_quality.desafio_quality.service;

import com.desafio_quality.desafio_quality.model.Residence;
import com.desafio_quality.desafio_quality.model.Room;
import com.desafio_quality.desafio_quality.repository.DistrictRepository;
import com.desafio_quality.desafio_quality.repository.ResidenceRepository;
import com.desafio_quality.desafio_quality.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidenceService implements IResidenceService {

    @Autowired
    private ResidenceRepository residenceRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private RoomRepository roomRepository;


    @Override
    public Room majorRoom(Residence residence) {
        return null;
    }

    @Override
    public Double squareResidence(Residence residence) {
        return null;
    }

    @Override
    public List<Residence> findAll() {
        return residenceRepository.getAllResidence();
    }

    @Override
    public void create(Residence residence) {
        residenceRepository.saveResidence(residence);
        this.returnResidence(residence);
    }

    public Residence returnResidence (Residence residence){
        return residence;
    }

    @Override
    public Residence read(String residenceName) {

        return residenceRepository.getByName(residenceName);
    }
//
//    public boolean verifyIfResidenceExists (String residenceName){
//        if (residenceName.equals())
//    }
}
