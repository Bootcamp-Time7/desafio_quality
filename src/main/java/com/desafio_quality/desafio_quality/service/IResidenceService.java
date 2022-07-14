package com.desafio_quality.desafio_quality.service;


import com.desafio_quality.desafio_quality.model.Residence;
import com.desafio_quality.desafio_quality.model.Room;

import java.util.List;

public interface IResidenceService {

    Residence calculateBiggestCommode(String residence);

    Double squareResidence (Residence residence); //soma das areas de todos os comodos

    List<Residence> findAll();

    void create(Residence residence);

    Residence read(String name);
}
