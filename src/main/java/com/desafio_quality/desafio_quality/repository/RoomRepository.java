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

    private List<Room>  roomData = new ArrayList ();



    public void saveRoom (Room newRoom){

        this.roomData.add(newRoom);
    }

    public List<Room> getAllRoom () {

        return this.roomData;
    }
}
