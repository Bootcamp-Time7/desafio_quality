package com.desafio_quality.desafio_quality.controller;

import com.desafio_quality.desafio_quality.handler.HandlerException;
import com.desafio_quality.desafio_quality.model.Residence;
import com.desafio_quality.desafio_quality.model.Room;
import com.desafio_quality.desafio_quality.model.RoomDto;
import com.desafio_quality.desafio_quality.service.IResidenceService;
import com.desafio_quality.desafio_quality.utils.TestUtilsGenerator;
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
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)

public class ResidenceControllerTest {

    @InjectMocks
    private ResidenceController controller;
    @Mock
    IResidenceService residenceService;

    @BeforeEach
    void setup() {
        BDDMockito.when(residenceService.calculateBiggestRoom(ArgumentMatchers.anyString()))
                .thenReturn(TestUtilsGenerator.getNewRoom());
        BDDMockito.when(residenceService.getSquareRooms(ArgumentMatchers.anyString()))
                .thenReturn(TestUtilsGenerator.getNewRoomDtoList());
        BDDMockito.when(residenceService.getTotalArea(ArgumentMatchers.anyString()))
                .thenReturn(TestUtilsGenerator.getTotalArea());
        BDDMockito.when(residenceService.getTotalPrice(ArgumentMatchers.anyString()))
                .thenReturn(TestUtilsGenerator.getTotalPrice());
        BDDMockito.when(residenceService.findAll())
                .thenReturn(TestUtilsGenerator.getNewResidenceList());
        BDDMockito.when(residenceService.read(ArgumentMatchers.anyString()))
                .thenReturn(TestUtilsGenerator.getNewResidence());
    }

    @Test
    void calculateBiggestCommode_returnRoom_whenRoomWasBiggest() {

        var room = TestUtilsGenerator.getNewRoom();

        ResponseEntity<Room> response = controller.calculateBiggestCommode(room.getRoomName());

        assertThat(Objects.requireNonNull(response.getBody()).getRoomName()).isEqualTo(room.getRoomName());
        verify(residenceService, atLeastOnce()).calculateBiggestRoom(room.getRoomName());

    }


    @Test
    void registerResidence() throws HandlerException {
        Residence newResidence = TestUtilsGenerator.getNewResidence();

        ResponseEntity<Residence> response = controller.registerResidence(newResidence);

        assertThat(Objects.requireNonNull(response.getBody()).getResidenceName()).isEqualTo(newResidence.getResidenceName());
        verify(residenceService, atLeastOnce()).create(newResidence);
    }


    @Test
    void getSquareRoom_returnRoomDto_whenResidenceExists() {
        Residence newResidence = TestUtilsGenerator.getNewResidence();

        ResponseEntity<List<RoomDto>> response = controller.getSquareRoom(newResidence.getResidenceName());

        double calculateSquare = newResidence.getListRooms().get(0).getRoomLength()*newResidence.getListRooms().get(0).getRoomWidth();

        Assertions.assertThat(Objects.requireNonNull(response.getBody()).get(0)).isNotNull();
        Assertions.assertThat(response.getBody().size()).isEqualTo(3);
        Assertions.assertThat(response.getBody().get(0).getSquare()).isEqualTo(calculateSquare);
        verify(residenceService, atLeastOnce()).getSquareRooms(newResidence.getResidenceName());

    }

    @Test
    void calculateTotalArea() {
        Residence newResidence = TestUtilsGenerator.getNewResidence();
        Double totalArea = TestUtilsGenerator.getTotalArea();

        ResponseEntity<Double> response = controller.calculateTotalArea(newResidence.getResidenceName());

        Assertions.assertThat(response.getBody()).isNotNull();
        Assertions.assertThat(response.getBody()).isEqualTo(totalArea);
        Assertions.assertThat(response.getBody()).isPositive();
        verify(residenceService, atLeastOnce()).getTotalArea(newResidence.getResidenceName());
    }

    @Test
    void totalPrice() {
        Residence newResidence = TestUtilsGenerator.getNewResidence();
        Double totalPrice = TestUtilsGenerator.getTotalPrice();

        ResponseEntity<Double> response = controller.totalPrice(newResidence.getResidenceName());

        Assertions.assertThat(response.getBody()).isNotNull();
        Assertions.assertThat(response.getBody()).isEqualTo(totalPrice);
        Assertions.assertThat(response.getBody()).isPositive();
        verify(residenceService, atLeastOnce()).getTotalPrice(newResidence.getResidenceName());

    }

    @Test
    void findAll() {
        List<Residence> residenceData = TestUtilsGenerator.getNewResidenceList();

       ResponseEntity<List<Residence>> response = controller.findAll();

        Assertions.assertThat(response.getBody()).isNotNull();
        Assertions.assertThat(response.getBody().size()).isEqualTo(3);
        Assertions.assertThat(response.getBody().get(0).getResidenceName()).isEqualTo(residenceData.get(0).getResidenceName());
        Assertions.assertThat(response.getBody()).isEqualTo(residenceData);
        verify(residenceService, atLeastOnce()).findAll();
    }

    @Test
    void readResidence() {
        Residence newResidence = TestUtilsGenerator.getNewResidence();

        ResponseEntity<Residence> response = controller.readResidence(newResidence.getResidenceName());

        Assertions.assertThat(response.getBody()).isNotNull();
        Assertions.assertThat(response.getBody().getResidenceName()).isEqualTo(newResidence.getResidenceName());
        Assertions.assertThat(response.getBody().getListRooms().size()).isEqualTo(3);
        verify(residenceService,atLeastOnce()).read(newResidence.getResidenceName());
    }
}
