package com.desafio_quality.desafio_quality.controller;

import com.desafio_quality.desafio_quality.model.Room;
import com.desafio_quality.desafio_quality.service.IResidenceService;
import com.desafio_quality.desafio_quality.utils.TestUtilsGenerator;
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

import java.util.Comparator;

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
    }

    @Test
    void getResidenceByNameTest() {

        var room = TestUtilsGenerator.getNewRoom();

        ResponseEntity<Room> response = controller.calculateBiggestCommode(room.getRoomName());

        verify(residenceService, atLeastOnce()).calculateBiggestRoom(room.getRoomName());
        assertThat(response.getBody().getRoomName()).isEqualTo(room.getRoomName());
    }




}
