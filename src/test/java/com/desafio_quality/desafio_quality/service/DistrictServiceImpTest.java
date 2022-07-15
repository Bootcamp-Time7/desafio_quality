package com.desafio_quality.desafio_quality.service;

import com.desafio_quality.desafio_quality.model.District;
import com.desafio_quality.desafio_quality.model.Residence;
import com.desafio_quality.desafio_quality.repository.DistrictRepository;
import com.desafio_quality.desafio_quality.repository.ResidenceRepository;
import com.desafio_quality.desafio_quality.utils.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class DistrictServiceImpTest {


    @InjectMocks
    DistrictServiceImp districtService;

    @Mock
    ResidenceRepository residenceRepository;

    @Mock
    DistrictRepository districtRepository;

    @BeforeEach
    public void setup(){

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
}
