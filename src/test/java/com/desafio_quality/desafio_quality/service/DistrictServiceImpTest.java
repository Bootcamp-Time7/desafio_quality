package com.desafio_quality.desafio_quality.service;

import com.desafio_quality.desafio_quality.excepiton.ElementAlreadyExistsException;
import com.desafio_quality.desafio_quality.model.District;
import com.desafio_quality.desafio_quality.model.Residence;
import com.desafio_quality.desafio_quality.repository.DistrictRepository;
import com.desafio_quality.desafio_quality.repository.ResidenceRepository;
import com.desafio_quality.desafio_quality.utils.TestUtilsGenerator;
import org.assertj.core.api.ListAssert;
import org.junit.jupiter.api.Assertions;
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
import org.mockito.stubbing.OngoingStubbing;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.LIST;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class DistrictServiceImpTest {



    @Mock
    DistrictRepository districtRepository;

    @BeforeEach
    public void setup() {
        BDDMockito.when(districtRepository.saveDistrict(ArgumentMatchers.any(District.class)))
                .thenReturn(TestUtilsGenerator.getNewDistrict());
    }

    @Test
    void read_returnDistrict_whenDistrictExist() {
        District district = TestUtilsGenerator.getNewDistrict();

        when(districtRepository.getByName(anyString())).thenReturn(district);

        DistrictServiceImp districtService = new DistrictServiceImp(districtRepository);

        District districtFound = districtService.read(district.getName());

        assertThat(districtFound.getName()).isEqualTo(district.getName());
        verify(districtRepository, atLeastOnce()).getByName(district.getName());
    }

    @Test
    void findAll_returnAllDistricts() {
        District district = TestUtilsGenerator.getNewDistrict();
        List<District> districtListtList = List.of(district);

        when(districtRepository.getAllDistrict()).thenReturn(districtListtList);
        DistrictServiceImp districtService = new DistrictServiceImp(districtRepository);

        var districtsFound = districtService.findAll();

        assertThat(districtsFound).isEqualTo(districtListtList);
        verify(districtRepository).getAllDistrict();
    }

    @Test
    void create_whenDistrictNotExistInRepository() throws Exception {
        District newDistrict = TestUtilsGenerator.getNewDistrict();

        DistrictServiceImp districtService = new DistrictServiceImp(districtRepository);
        var savedDistrict = districtService.create(newDistrict);

        assertThat(savedDistrict.getName()).isEqualTo(savedDistrict.getName());
        assertThat(savedDistrict.getValuePerSquare()).isEqualTo(savedDistrict.getValuePerSquare());
        verify(districtRepository, atLeastOnce()).saveDistrict(newDistrict);
    }

    @Test
    void create_whenDistrictExistInRepository(){
        District newDistrict = TestUtilsGenerator.getNewDistrict();
        when(districtRepository.getByName(anyString())).thenReturn(newDistrict);

        DistrictServiceImp districtService = new DistrictServiceImp(districtRepository);

        Assertions.assertThrows(ElementAlreadyExistsException.class, () -> districtService.create(newDistrict));

    }
}
