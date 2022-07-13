package com.desafio_quality.desafio_quality.service;

import com.desafio_quality.desafio_quality.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService implements IRoomService{

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Double SquareRoom() {
        return null;
    }
}
