package com.desafio_quality.desafio_quality.repository;

import com.desafio_quality.desafio_quality.utils.TestUtilsGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class DistrictRepositoryTest {
    @BeforeEach
    void setup() {

    }

    @Test
    void getListDistrict() {

    }

    @Test
    void saveDistrict() {
    }

    @Test
    void getAllDistrict() {

        var districtList= TestUtilsGenerator.getNewDistrictList();

        Assertions.assertThat(districtList.size()).isEqualTo(districtList.get(3));

    }

    @Test
    void getByName() {
    }
}
