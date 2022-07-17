package com.desafio_quality.desafio_quality.repository;

import com.desafio_quality.desafio_quality.model.District;
import com.desafio_quality.desafio_quality.utils.TestUtilsGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class DistrictRepositoryTest {

    @InjectMocks
    DistrictRepository districtRepository;


    @BeforeEach
    void setup() {

    }

    @Test
    void saveDistrict() {
        District newDistric = TestUtilsGenerator.getNewDistrict();

        District savedDistrict = districtRepository.saveDistrict(newDistric);

        Assertions.assertThat(savedDistrict).isNotNull();
        Assertions.assertThat(savedDistrict).isInstanceOf(District.class);
        Assertions.assertThat(savedDistrict).isEqualTo(newDistric);
    }

    @Test
    void getAllDistrict() {
        District newDistrict = districtRepository.saveDistrict(TestUtilsGenerator.getNewDistrict());

        List<District> responseDistrictList = districtRepository.getAllDistrict();

        Assertions.assertThat(responseDistrictList).isNotNull();
        Assertions.assertThat(responseDistrictList.size()).isEqualTo(1);
        Assertions.assertThat(responseDistrictList.get(0)).isInstanceOf(District.class);
        Assertions.assertThat(responseDistrictList.get(0)).isEqualTo(newDistrict);
    }

    @Test
    void getByName_returnDistrict_whenDistrictExists() {
        District district = TestUtilsGenerator.getNewDistrict();

        districtRepository.saveDistrict(district);

        District foundDistrict = districtRepository.getByName(district.getName());

        Assertions.assertThat(foundDistrict).isNotNull();
        Assertions.assertThat(foundDistrict).isEqualTo(district);
        Assertions.assertThat(foundDistrict).isInstanceOf(District.class);
    }

    @Test
    void getByName_returnNull_whenDistrictNotExists() {
        District district = TestUtilsGenerator.getNewDistrict();

        District foundDistrict = districtRepository.getByName(district.getName());

        Assertions.assertThat(foundDistrict).isNull();
    }
}
