package com.desafio_quality.desafio_quality.repository;


import com.desafio_quality.desafio_quality.model.Property;
import com.desafio_quality.desafio_quality.model.Room;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PropertyRepository {

    private final static String propertyJson = "src/main/resources/property.json";


    public List<Property> getAllProperty (){
        ObjectMapper lendoJsonProperty = new ObjectMapper();
        List<Property> listProperty=null;


        try{
            listProperty = Arrays.asList(lendoJsonProperty.readValue(new File(propertyJson), Property[].class));
        }
        catch(Exception e ) {

        }
        return null;
    }
}
