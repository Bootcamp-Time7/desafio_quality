package com.desafio_quality.desafio_quality.controller;

import com.desafio_quality.desafio_quality.model.Room;
import com.desafio_quality.desafio_quality.service.IResidenceService;
import com.desafio_quality.desafio_quality.utils.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.ResponseEntity;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;
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
//        BDDMockito.when(residenceService.calculateBiggestRoom(ArgumentMatchers.anyString()))
//                .thenReturn(TestUtilsGenerator.getNewResidence());
    }

    @Test
    void getResidenceByNameTest() {
        var roomList= TestUtilsGenerator.getNewRoomList();
        var residence= TestUtilsGenerator.getNewResidence();
        var room = roomList
                .stream().max(Comparator.comparing(Room::CalculateArea)).get();

        ResponseEntity<Room> response = controller.calculateBiggestCommode(residence.getResidenceName());
//
//        verify(residenceService, atLeastOnce()).calculateBiggestRoom(residence.getResidenceName());
//        assertThat(response.getBody().getResidenceName()).isEqualTo(residence.getResidenceName());
    }


}
