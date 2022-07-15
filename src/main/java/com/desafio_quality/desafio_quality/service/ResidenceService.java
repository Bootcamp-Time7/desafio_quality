package com.desafio_quality.desafio_quality.service;

import com.desafio_quality.desafio_quality.model.Residence;
import com.desafio_quality.desafio_quality.model.Room;
import com.desafio_quality.desafio_quality.model.RoomDto;
import com.desafio_quality.desafio_quality.repository.DistrictRepository;
import com.desafio_quality.desafio_quality.repository.ResidenceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ResidenceService implements IResidenceService {

    private ResidenceRepository residenceRepository;

    private DistrictRepository districtRepository;

    public ResidenceService(ResidenceRepository residenceRepository, DistrictRepository districtRepository) {
        this.residenceRepository = residenceRepository;
        this.districtRepository = districtRepository;
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
        List<Residence> tempResidenceList = findAll();
        boolean found = false;
        for (Residence r : tempResidenceList) {
            if (r.getResidenceName().equalsIgnoreCase(residence.getResidenceName())) {
                found = true;
                System.out.print("esse elemento ja existe"); // TODO Throw New Exception
            }
        }
        if (!found) {
            residenceRepository.saveResidence(residence);
        }
    }

    public Residence returnResidence(Residence residence) {
        return residence;
    }

    @Override
    public Residence read(String residenceName) {

        return residenceRepository.getByName(residenceName);
    }

//    public boolean verifyIfResidenceExists (String residenceName){
//        for(Residence r :residenceRepository.getListResidence()){
//            if (residenceName.equals(r.getResidenceName())){
//                System.out.println("erro");
//                //TODO throw new
//            }
//        }
//        return false;
//    }

    public List<RoomDto> getSquareRooms(String residence) {
        List<RoomDto> roomSquareList = new ArrayList<>();
        Residence residenceFound = residenceRepository.getByName(residence);
        List<Room> roomList = residenceFound.getListRooms();
        for (Room room : roomList) {
            RoomDto newRoomDto = new RoomDto();
            newRoomDto.setNameRoomDto(room.getRoomName());
            newRoomDto.setSquare(room.getRoomWidth()* room.getRoomWidth());
            roomSquareList.add(newRoomDto);

        }
        return roomSquareList;
    }

    public Double getTotalArea(String residence) {
        Double totalArea =0.0;
        Residence residenceFound = residenceRepository.getByName(residence);
        List<Room> roomList = residenceFound.getListRooms();
        for (Room room : roomList) {
            Double squareRoom = Room.calculateArea(room);
             totalArea =  totalArea + squareRoom;
        }
        return totalArea;
    }


    public Double getTotalPrice(String residence) {
        double totalArea = 0.0;
        Residence residenceFound = residenceRepository.getByName(residence);
        List<Room> roomList = residenceFound.getListRooms();
        for (Room room : roomList) {
            Double squareRoom = Room.calculateArea(room);
            totalArea = totalArea + squareRoom;
        }
        return totalArea * residenceFound.getResidenceDistrict().getValuePerSquare();
    }


    //    List<Residence> tempPropertyList = residenceRepository.getAllResidence();
//    Residence tempResidence = new Residence();
//        for(Residence residenceIterator:tempPropertyList){
//        if (residenceIterator.getResidenceName().equals(residenceName)){
//            tempResidence = residenceIterator;
//        }
//    }
//    List<Room> tempRoomList = tempResidence.getListRooms();
//    double totalArea = 0.0;
//
//        for (Room roomIterator:tempRoomList){
//        totalArea +=  roomIterator.getRoomLength()*roomIterator.getRoomWidth();
//    }
    public Room calculateBiggestRoom(String residence) {
        var listRooms = residenceRepository.getByName(residence).getListRooms();

        return listRooms
                .stream().max(Comparator.comparing(Room::calculateArea)).get();
    }

//
//    public boolean verifyIfResidenceExists (String residenceName){
//        if (residenceName.equals())
//    }
}
