package com.desafio_quality.desafio_quality.service;

import com.desafio_quality.desafio_quality.model.Residence;
import com.desafio_quality.desafio_quality.model.Room;
import com.desafio_quality.desafio_quality.repository.DistrictRepository;
import com.desafio_quality.desafio_quality.repository.ResidenceRepository;
import com.desafio_quality.desafio_quality.utils.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)

public class ResidenceServiceTest {

    @Mock
    ResidenceRepository residenceRepository;

    @Mock
    DistrictRepository districtRepository;

    @BeforeEach
    public void setup(){

    }

    @Test
    void read_returnResidence_whenResidenceExist() {
        Residence residence = TestUtilsGenerator.getNewResidence();

        when(residenceRepository.getByName(anyString())).thenReturn(residence);

        ResidenceService residenceService = new ResidenceService(residenceRepository, districtRepository);

        Residence residencetFound = residenceService.read(residence.getResidenceName());

        assertThat(residencetFound.getResidenceName()).isEqualTo(residence.getResidenceName());
        verify(residenceRepository, atLeastOnce()).getByName(residence.getResidenceName());
    }

    @Test
    void calculateBiggestRoom(){
        Residence residence = TestUtilsGenerator.getNewResidence();
        when(residenceRepository.getByName(residence.getResidenceName())).thenReturn(residence);

        var roomList= TestUtilsGenerator.getNewRoomList();
        residence.setListRooms(roomList);

        var expectedBiggestRoom = roomList
                .stream().max(Comparator.comparing(Room::SquareRoom)).get();

        ResidenceService residenceService = new ResidenceService(residenceRepository, districtRepository);

         Room biggestRoom = residenceService.calculateBiggestRoom(residence.getResidenceName());

         assertThat(biggestRoom).isEqualTo(expectedBiggestRoom);
         verify(residenceRepository).getByName(residence.getResidenceName());
    }



}
