package com.desafio_quality.desafio_quality.service;

import com.desafio_quality.desafio_quality.model.Room;

import java.util.List;

public interface IRoomService {

    Double SquareRoom ();
    List<Room> findAll();
    void create(Room room);


}
