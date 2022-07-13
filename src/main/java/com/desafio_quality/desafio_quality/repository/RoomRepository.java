package com.desafio_quality.desafio_quality.repository;


import com.desafio_quality.desafio_quality.model.Room;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class RoomRepository {

    private final static String roomJsonFile = "src/main/resources/room.json";

    public List<Room> getAllRoom (){
        ObjectMapper lendoJsonRoom = new ObjectMapper();
        List<Room> listRoom = new ArrayList<>();
    try{
        listRoom = Arrays.asList(lendoJsonRoom.readValue(new File(roomJsonFile), Room[].class));
    }
    catch(Exception e ) {

        }
    return null;
    }


}
