package com.desafio_quality.desafio_quality.service;

import com.desafio_quality.desafio_quality.model.Residence;
import com.desafio_quality.desafio_quality.model.Room;
import com.desafio_quality.desafio_quality.repository.DistrictRepository;
import com.desafio_quality.desafio_quality.repository.ResidenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResidenceService implements IResidenceService {

    @Autowired
    private ResidenceRepository residenceRepository;

    @Autowired
    private DistrictRepository districtRepository;


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
        if(!verifyIfResidenceExists(residence.getResidenceName())){
            residenceRepository.saveResidence(residence);
        }
        this.returnResidence(residence);
    }

    public Residence returnResidence (Residence residence){
        return residence;
    }

    @Override
    public Residence read(String residenceName) {

        return residenceRepository.getByName(residenceName);
    }

    public boolean verifyIfResidenceExists (String residenceName){
        for(Residence r :residenceRepository.getListResidence()){
            if (residenceName.equals(r.getResidenceName())){
                System.out.println("erro");
                //TODO throw new
            }
        }
        return false;
    }

    public List<String> getSquareRooms(String residence){
        String residencieRoom =null;
        List<String> roomSquareList = new ArrayList<>();
        List<Residence> residenceList = residenceRepository.getAllResidence();
        for(Residence r : residenceList){
            if(r.getResidenceName().equalsIgnoreCase(residence)){
                List<Room> roomList = r.getListRooms();
                for(Room room : roomList){
                  residencieRoom = "" + room.getRoomName() + ": " + Room.SquareRoom(room);
                  roomSquareList.add(residencieRoom);
                }
            }
        }
        return roomSquareList;
    }
}
