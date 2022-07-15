package com.desafio_quality.desafio_quality.service;

import com.desafio_quality.desafio_quality.excepiton.ElementAlreadyExistsException;
import com.desafio_quality.desafio_quality.model.Residence;
import com.desafio_quality.desafio_quality.model.Room;
import com.desafio_quality.desafio_quality.model.RoomDto;
import com.desafio_quality.desafio_quality.repository.DistrictRepository;
import com.desafio_quality.desafio_quality.repository.ResidenceRepository;
import com.desafio_quality.desafio_quality.utils.TestUtilsGenerator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
        BDDMockito.when(residenceRepository.getAllResidence())
                .thenReturn(TestUtilsGenerator.getNewResidenceList());
        BDDMockito.doNothing().when(residenceRepository)
                .saveResidence(ArgumentMatchers.any(Residence.class));
    }

    @Test
    @DisplayName("calculateBiggestRoom")
    void calculateBiggestRoom() {
        Residence residence = TestUtilsGenerator.getNewResidence();
        when(residenceRepository.getByName(residence.getResidenceName())).thenReturn(residence);

        var roomList = TestUtilsGenerator.getNewRoomList();
        residence.setListRooms(roomList);

        var expectedBiggestRoom = roomList
                .stream().max(Comparator.comparing(Room::calculateArea)).get();

        ResidenceService residenceService = new ResidenceService(residenceRepository, districtRepository);

        Room biggestRoom = residenceService.calculateBiggestRoom(residence.getResidenceName());

        assertThat(biggestRoom).isEqualTo(expectedBiggestRoom);
        verify(residenceRepository).getByName(residence.getResidenceName());
    }


    @Test
    @DisplayName("findAll")
    void findAll_returnResidenceList_whenResidenceListExists() {
        List<Residence> residenceData = TestUtilsGenerator.getNewResidenceList();

        List<Residence> foundResidenceList = residenceService.findAll();

        Assertions.assertThat(foundResidenceList).isNotNull();
        Assertions.assertThat(foundResidenceList.size()).isEqualTo(3);
        Assertions.assertThat(foundResidenceList.get(0).getResidenceName()).isEqualTo(residenceData.get(0).getResidenceName());
        Assertions.assertThat(foundResidenceList).isEqualTo(residenceData);
    }

    @Test
    @DisplayName("create")
    void create_doesNotThrowAnException_whenNewResidence() {
        BDDMockito.when(residenceRepository.getByName(ArgumentMatchers.anyString()))
                .thenReturn(null);
        Residence newResidence = TestUtilsGenerator.getNewResidence();
        Assertions.assertThatCode(() -> {
            residenceService.create(newResidence);
        }).doesNotThrowAnyException();

        verify(residenceRepository, atLeastOnce()).saveResidence(newResidence);
    }

    @Test
    @DisplayName("create")
    void create_doesThrowAnException_whenResidenceExists() {
        Residence residenceTest = TestUtilsGenerator.getNewResidence();
        Assertions.assertThatThrownBy(() -> residenceService.create(residenceTest))
                .isInstanceOf(ElementAlreadyExistsException.class);
    }

    @Test
    @DisplayName("read")
    void read_returnResidence_whenResidenceExists() {
        Residence newResidence = TestUtilsGenerator.getNewResidence();

        Residence foundResidence = residenceService.read(newResidence.getResidenceName());

        Assertions.assertThat(foundResidence).isNotNull();
        Assertions.assertThat(foundResidence.getResidenceName()).isEqualTo(newResidence.getResidenceName());
        Assertions.assertThat(foundResidence.getListRooms().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("getSquareRoom")
    void getSquareRooms_returnRoomDto_whenResidenceExists() {
        Residence newResidence =TestUtilsGenerator.getNewResidence();

        List<RoomDto> foundRoomDtoList = residenceService.getSquareRooms(newResidence.getResidenceName());

        double calculateSquare = newResidence.getListRooms().get(0).getRoomLength()*newResidence.getListRooms().get(0).getRoomWidth();

        Assertions.assertThat(foundRoomDtoList.get(0)).isNotNull();
        Assertions.assertThat(foundRoomDtoList.size()).isEqualTo(3);
        Assertions.assertThat(foundRoomDtoList.get(0).getSquare()).isEqualTo(calculateSquare);

    }

    @Test
    @DisplayName("getTotalArea")
    void getTotalArea_returnDouble_whenResidenceExists() {
        Residence newResidence =TestUtilsGenerator.getNewResidence();
        Double newTotalArea = TestUtilsGenerator.getTotalArea();

        Double foundTotalArea = residenceService.getTotalArea(newResidence.getResidenceName());

        Assertions.assertThat(foundTotalArea).isNotNull();
        Assertions.assertThat(foundTotalArea).isEqualTo(newTotalArea);
        Assertions.assertThat(foundTotalArea).isPositive();

    }

    @Test
    @DisplayName("getTotalPrice")
    void getTotalPrice_returnDouble_WhenResidenceExists() {
        Residence newResidence = TestUtilsGenerator.getNewResidence();
        Double newTotalPrice = TestUtilsGenerator.getTotalPrice();

        Double foundTotalPrice = residenceService.getTotalPrice(newResidence.getResidenceName());

        Assertions.assertThat(foundTotalPrice).isNotNull();
        Assertions.assertThat(foundTotalPrice).isEqualTo(newTotalPrice);
        Assertions.assertThat(foundTotalPrice).isPositive();
    }

}
