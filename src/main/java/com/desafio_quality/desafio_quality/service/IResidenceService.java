package com.desafio_quality.desafio_quality.service;


import com.desafio_quality.desafio_quality.model.Residence;
import com.desafio_quality.desafio_quality.model.Room;
import com.desafio_quality.desafio_quality.model.RoomDto;

import java.util.List;

public interface IResidenceService {

    Room calculateBiggestRoom(String residence);

    Double squareResidence (Residence residence); //soma das areas de todos os comodos

    List<Residence> findAll();

    void create(Residence residence);

    Residence read(String name);

//    public boolean verifyIfResidenceExists (String residenceName);

    public List <RoomDto> getSquareRooms(String residence);

    public Double getTotalArea(String residenceName);

    public Double getTotalPrice(String residenceName);
}
