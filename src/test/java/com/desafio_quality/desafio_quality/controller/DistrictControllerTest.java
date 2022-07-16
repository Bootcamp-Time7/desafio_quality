package com.desafio_quality.desafio_quality.controller;

import com.desafio_quality.desafio_quality.handler.HandlerException;
import com.desafio_quality.desafio_quality.model.District;
import com.desafio_quality.desafio_quality.model.Residence;
import com.desafio_quality.desafio_quality.service.IDistrictService;
import com.desafio_quality.desafio_quality.service.IResidenceService;
import com.desafio_quality.desafio_quality.utils.TestUtilsGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
public class DistrictControllerTest {

    @InjectMocks
    private DistrictController controller;
    @Mock
    IDistrictService districtService;

    @BeforeEach
    void setup() {
        BDDMockito.when(districtService.findAll())
                .thenReturn(TestUtilsGenerator.getNewDistrictList());
    }

    @Test
    void registerDistrict() throws HandlerException {
        District newDistrict = TestUtilsGenerator.getNewDistrict();

        ResponseEntity<District> response = controller.registerDistrict(newDistrict);

        assertThat(Objects.requireNonNull(response.getBody()).getName()).isEqualTo(newDistrict.getName());
        verify(districtService, atLeastOnce()).create(newDistrict);
    }

    @Test
    void findAll() {
        List<District> districtData = TestUtilsGenerator.getNewDistrictList();

        ResponseEntity<List<District>> response = controller.findAll();

        Assertions.assertThat(response.getBody()).isNotNull();
        Assertions.assertThat(response.getBody().size()).isEqualTo(3);
        Assertions.assertThat(response.getBody().get(0).getName()).isEqualTo(districtData.get(0).getName());
        Assertions.assertThat(response.getBody()).isEqualTo(districtData);
        verify(districtService, atLeastOnce()).findAll();
    }
}
