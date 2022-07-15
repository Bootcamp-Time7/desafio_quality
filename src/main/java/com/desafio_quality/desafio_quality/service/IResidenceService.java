package com.desafio_quality.desafio_quality.service;


import com.desafio_quality.desafio_quality.model.Residence;
import com.desafio_quality.desafio_quality.model.Room;
import com.desafio_quality.desafio_quality.model.RoomDto;

import java.util.List;

public interface IResidenceService {

    Room calculateBiggestRoom(String residence);

    List<Residence> findAll();

    void create(Residence residence);

    Residence read(String name);

    public List <RoomDto> getSquareRooms(String residence);

    public Double getTotalArea(String residenceName);

    public Double getTotalPrice(String residenceName);
}
