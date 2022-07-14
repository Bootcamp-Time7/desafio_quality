package com.desafio_quality.desafio_quality.utils;

import com.desafio_quality.desafio_quality.model.District;
import com.desafio_quality.desafio_quality.model.Residence;
import com.desafio_quality.desafio_quality.model.Room;

import java.util.ArrayList;
import java.util.List;

public class TestUtilsGenerator {

    public static void clearMemoryResidence(List<Residence> residenceList){
        residenceList.clear();
    }
    public static void clearMemoryDistrict(List<District> districtList){
        districtList.clear();
    }

    public static Room getNewRoom(){

        return Room.builder()
                .roomName("Quarto")
                .roomLength(2.0)
                .roomWidth(2.0)
                .build();
    }

    public static List<Room> getNewRoomList(){
        Room room1 = new Room("Quarto", 2.0, 2.0);
        Room room2 = new Room("Sala", 1.0, 1.0);
        Room room3 = new Room("Cozinha", 4.0, 4.0);

        List<Room> roomList = new ArrayList<>();
        roomList.add(room1);
        roomList.add(room2);
        roomList.add(room3);

        return roomList;
    }

    public static District getNewDistrict(){
        return District.builder()
                .name("Liberdade")
                .valuePerSquare(2.0)
                .build();
    }

    public static List<District> getNewDistrictList(){
        District district1 = new District("Liberdade", 1.0);
        District district2 = new District("Vila Mariana", 2.0);
        District district3 = new District("Mooca", 3.0);

        List<District> districtList = new ArrayList<>();
        districtList.add(district1);
        districtList.add(district2);
        districtList.add(district3);

        return districtList;
    }

    public static Residence getNewResidence(){
        List<Room> roomList = getNewRoomList();
        District district = getNewDistrict();

        return Residence.builder()
                .residenceName("Casa")
                .residenceDistrict(district)
                .listRooms(roomList)
                .build();
    }

}
