package com.desafio_quality.desafio_quality.service;


import com.desafio_quality.desafio_quality.model.Residence;
import com.desafio_quality.desafio_quality.model.Room;

public interface IResidenceService {

    Room majorRoom (Residence residence);

    Double squareResidence (Residence residence); //soma das areas de todos os comodos
}
