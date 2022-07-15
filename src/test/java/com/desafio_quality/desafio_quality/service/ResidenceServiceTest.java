package com.desafio_quality.desafio_quality.service;

import com.desafio_quality.desafio_quality.model.Residence;
import com.desafio_quality.desafio_quality.model.Room;
import com.desafio_quality.desafio_quality.model.RoomDto;
import com.desafio_quality.desafio_quality.repository.DistrictRepository;
import com.desafio_quality.desafio_quality.repository.ResidenceRepository;
import com.desafio_quality.desafio_quality.utils.TestUtilsGenerator;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)

public class ResidenceServiceTest {

    @InjectMocks
    ResidenceService residenceService;

    @Mock
    ResidenceRepository residenceRepository;

    @Mock
    DistrictRepository districtRepository;

    @BeforeEach
    public void setup(){
        BDDMockito.when(residenceRepository.getByName(ArgumentMatchers.anyString()))
                .thenReturn(TestUtilsGenerator.getNewResidence());
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
                .stream().max(Comparator.comparing(Room::calculateArea)).get();

        ResidenceService residenceService = new ResidenceService(residenceRepository, districtRepository);

         Room biggestRoom = residenceService.calculateBiggestRoom(residence.getResidenceName());

         assertThat(biggestRoom).isEqualTo(expectedBiggestRoom);
         verify(residenceRepository).getByName(residence.getResidenceName());
    }


    @Test
    void squareResidence() {

    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void returnResidence() {
    }

    @Test
    void read() {
    }

    @Test
    void getSquareRooms_returnRoomDto_whenResidenceExists() {
        Residence newResidence =TestUtilsGenerator.getNewResidence();

        List<RoomDto> foundRoomDtoList = residenceService.getSquareRooms(newResidence.getResidenceName());

        double calculateSquare = newResidence.getListRooms().get(0).getRoomLength()*newResidence.getListRooms().get(0).getRoomWidth();

        Assertions.assertThat(foundRoomDtoList.get(0)).isNotNull();
        Assertions.assertThat(foundRoomDtoList.size()).isEqualTo(3);
        Assertions.assertThat(foundRoomDtoList.get(0).getSquare()).isEqualTo(calculateSquare);

    }

    @Test
    void getTotalArea_returnDouble_whenResidenceExists() {
        Residence newResidence =TestUtilsGenerator.getNewResidence();
        Double newTotalArea = TestUtilsGenerator.getTotalArea();

        Double foundTotalArea = residenceService.getTotalArea(newResidence.getResidenceName());

        Assertions.assertThat(foundTotalArea).isNotNull();
        Assertions.assertThat(foundTotalArea).isEqualTo(newTotalArea);
        Assertions.assertThat(foundTotalArea).isPositive();

    }

    @Test
    void getTotalPrice() {
    }

    @Test
    void testCalculateBiggestRoom() {
    }
}
