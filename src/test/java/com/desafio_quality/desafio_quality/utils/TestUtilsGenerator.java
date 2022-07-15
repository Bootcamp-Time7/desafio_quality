package com.desafio_quality.desafio_quality.utils;

import com.desafio_quality.desafio_quality.model.District;
import com.desafio_quality.desafio_quality.model.Residence;
import com.desafio_quality.desafio_quality.model.Room;
import com.desafio_quality.desafio_quality.model.RoomDto;

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

    public static List<RoomDto> getNewRoomDtoList(){

        RoomDto room1 = new RoomDto("Quarto", 4.0);
        RoomDto room2 = new RoomDto("Quarto", 4.0);
        RoomDto room3 = new RoomDto("Quarto", 4.0);

        List<RoomDto> roomDtoList = new ArrayList<>();
        roomDtoList.add(room1);
        roomDtoList.add(room2);
        roomDtoList.add(room3);

        return roomDtoList;
    }

    public static RoomDto getNewRoomDto(){

       return  RoomDto.builder()
               .nameRoomDto("room")
               .square(2)
               .build();

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
    public static List<Residence> getNewResidenceList(){
        Residence residence1 =
                Residence.builder()
                        .residenceName("casa1")
                        .residenceDistrict(getNewDistrict())
                        .listRooms(getNewRoomList())
                        .build();

        Residence residence2 =
                Residence.builder()
                        .residenceName("casa2")
                        .residenceDistrict(getNewDistrict())
                        .listRooms(getNewRoomList())
                        .build();

        Residence residence3 =
                Residence.builder()
                        .residenceName("casa3")
                        .residenceDistrict(getNewDistrict())
                        .listRooms(getNewRoomList())
                        .build();

        List<Residence> residenceList = new ArrayList<>();
        residenceList.add(residence1);
        residenceList.add(residence2);
        residenceList.add(residence3);


        return residenceList;
    }

    public static Double getTotalArea(){

        Residence residence = getNewResidence();

       double squareRoom0=  residence.getListRooms().get(0).getRoomWidth()*residence.getListRooms().get(0).getRoomLength();
       double squareRoom1=  residence.getListRooms().get(1).getRoomWidth()*residence.getListRooms().get(1).getRoomLength();
       double squareRoom2=  residence.getListRooms().get(2).getRoomWidth()*residence.getListRooms().get(2).getRoomLength();

       double totalAreaRooms = squareRoom0 + squareRoom1 + squareRoom2;

       return totalAreaRooms;
    }

    public static Double getTotalPrice(){

        Residence residence = getNewResidence();

        Double totalAreaRooms = getTotalArea();

        return  totalAreaRooms* residence.getResidenceDistrict().getValuePerSquare();
    }

}
