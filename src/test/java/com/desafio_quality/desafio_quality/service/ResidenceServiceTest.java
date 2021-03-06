package com.desafio_quality.desafio_quality.service;

import com.desafio_quality.desafio_quality.excepiton.ElementAlreadyExistsException;
import com.desafio_quality.desafio_quality.model.District;
import com.desafio_quality.desafio_quality.model.Residence;
import com.desafio_quality.desafio_quality.model.Room;
import com.desafio_quality.desafio_quality.model.RoomDto;
import com.desafio_quality.desafio_quality.repository.DistrictRepository;
import com.desafio_quality.desafio_quality.repository.ResidenceRepository;
import com.desafio_quality.desafio_quality.utils.TestUtilsGenerator;
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

import static java.util.Optional.ofNullable;
import static org.assertj.core.api.Assertions.*;
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
        when(residenceRepository.getByName(ArgumentMatchers.anyString()))
                .thenReturn(TestUtilsGenerator.getNewResidence());
        when(residenceRepository.getAllResidence())
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

        assertThat(foundResidenceList).isNotNull();
        assertThat(foundResidenceList.size()).isEqualTo(3);
        assertThat(foundResidenceList.get(0).getResidenceName()).isEqualTo(residenceData.get(0).getResidenceName());
        assertThat(foundResidenceList).isEqualTo(residenceData);
    }

    @Test
    @DisplayName("create")
    void create_doesNotThrowAnException_whenNewResidenceAndNewDistric() {
        when(residenceRepository.getByName(ArgumentMatchers.anyString()))
                .thenReturn(null);
        when(districtRepository.getByName(ArgumentMatchers.anyString()))
                .thenReturn(null);
        Residence newResidence = TestUtilsGenerator.getNewResidence();
        District newDistrict = newResidence.getResidenceDistrict();
        assertThatCode(() -> {
            residenceService.create(newResidence);
        }).doesNotThrowAnyException();

        verify(residenceRepository, atLeastOnce()).saveResidence(newResidence);
        verify(districtRepository, atLeastOnce()).saveDistrict(newDistrict);
    }

    @Test
    @DisplayName("create")
    void create_doesNotThrowAnException_whenNewResidence() {
        when(residenceRepository.getByName(ArgumentMatchers.anyString()))
                .thenReturn(null);
        when(districtRepository.getByResidence(ArgumentMatchers.any(Residence.class)))
                .thenReturn(ofNullable(TestUtilsGenerator.getNewDistrict()));

        Residence newResidence = TestUtilsGenerator.getNewResidence();
        assertThatCode(() -> residenceService.create(newResidence)).doesNotThrowAnyException();

        verify(residenceRepository, atLeastOnce()).saveResidence(newResidence);
        verify(districtRepository, never()).saveDistrict(newResidence.getResidenceDistrict());
    }

    @Test
    @DisplayName("create")
    void create_doesThrowAnException_whenResidenceExists() {
        Residence residenceTest = TestUtilsGenerator.getNewResidence();
        assertThatThrownBy(() -> residenceService.create(residenceTest))
                .isInstanceOf(ElementAlreadyExistsException.class);
    }

    @Test
    @DisplayName("read")
    void read_returnResidence_whenResidenceExists() {
        Residence newResidence = TestUtilsGenerator.getNewResidence();

        Residence foundResidence = residenceService.read(newResidence.getResidenceName());

        assertThat(foundResidence).isNotNull();
        assertThat(foundResidence.getResidenceName()).isEqualTo(newResidence.getResidenceName());
        assertThat(foundResidence.getListRooms().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("getSquareRoom")
    void getSquareRooms_returnRoomDto_whenResidenceExists() {
        Residence newResidence =TestUtilsGenerator.getNewResidence();

        List<RoomDto> foundRoomDtoList = residenceService.getSquareRooms(newResidence.getResidenceName());

        double calculateSquare = newResidence.getListRooms().get(0).getRoomLength()*newResidence.getListRooms().get(0).getRoomWidth();

        assertThat(foundRoomDtoList.get(0)).isNotNull();
        assertThat(foundRoomDtoList.size()).isEqualTo(3);
        assertThat(foundRoomDtoList.get(0).getSquare()).isEqualTo(calculateSquare);

    }

    @Test
    @DisplayName("getTotalArea")
    void getTotalArea_returnDouble_whenResidenceExists() {
        Residence newResidence =TestUtilsGenerator.getNewResidence();
        Double newTotalArea = TestUtilsGenerator.getTotalArea();

        Double foundTotalArea = residenceService.getTotalArea(newResidence.getResidenceName());

        assertThat(foundTotalArea).isNotNull();
        assertThat(foundTotalArea).isEqualTo(newTotalArea);
        assertThat(foundTotalArea).isPositive();

    }

    @Test
    @DisplayName("getTotalPrice")
    void getTotalPrice_returnDouble_WhenResidenceExists() {
        Residence newResidence = TestUtilsGenerator.getNewResidence();
        Double newTotalPrice = TestUtilsGenerator.getTotalPrice();

        Double foundTotalPrice = residenceService.getTotalPrice(newResidence.getResidenceName());

        assertThat(foundTotalPrice).isNotNull();
        assertThat(foundTotalPrice).isEqualTo(newTotalPrice);
        assertThat(foundTotalPrice).isPositive();
    }

}
