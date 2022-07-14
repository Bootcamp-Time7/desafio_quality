package com.desafio_quality.desafio_quality.service;

import com.desafio_quality.desafio_quality.model.Room;
import com.desafio_quality.desafio_quality.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService implements IRoomService{

    @Autowired
    private RoomRepository roomRepository;


    @Override
    public Double SquareRoom() {

        return null;
    }

    @Override
    public List<Room> findAll() {
        return roomRepository.getAllRoom();
    }

    @Override
    public void create(Room room) {
        roomRepository.saveRoom(room);
    }


}
