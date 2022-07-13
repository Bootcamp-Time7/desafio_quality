package com.desafio_quality.desafio_quality.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {
    private String propertyName;
    private String propertyDistrict;
    private List<Room> listRooms;

}
