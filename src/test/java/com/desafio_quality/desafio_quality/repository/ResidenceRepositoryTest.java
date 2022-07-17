package com.desafio_quality.desafio_quality.repository;

import com.desafio_quality.desafio_quality.model.District;
import com.desafio_quality.desafio_quality.model.Residence;
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
public class ResidenceRepositoryTest {

    @InjectMocks
    ResidenceRepository residenceRepository;

    @BeforeEach
    void setup() {

    }

    @Test
    void saveResidence() {

        Residence newResidence = TestUtilsGenerator.getNewResidence();

        Assertions.assertThatCode(()
                -> residenceRepository.saveResidence(newResidence))
                .doesNotThrowAnyException();

        List<Residence> residenceData = residenceRepository.getAllResidence();

        Assertions.assertThat(residenceData).isNotNull();
        Assertions.assertThat(residenceData.get(0)).isEqualTo(newResidence);
    }

    @Test
    void getAllResidence() {
        residenceRepository.saveResidence(TestUtilsGenerator.getNewResidence());

        List<Residence> residenceData = residenceRepository.getAllResidence();

        Assertions.assertThat(residenceData).isNotNull();
        Assertions.assertThat(residenceData.size()).isEqualTo(1);
        Assertions.assertThat(residenceData.get(0)).isInstanceOf(Residence.class);

    }

    @Test
    void getByName_returnResidence_whenResidenceExists() {
        Residence residence = TestUtilsGenerator.getNewResidence();

        residenceRepository.saveResidence(residence);

        Residence foundResidence = residenceRepository.getByName(residence.getResidenceName());

        Assertions.assertThat(foundResidence).isNotNull();
        Assertions.assertThat(foundResidence).isEqualTo(residence);
        Assertions.assertThat(foundResidence).isInstanceOf(Residence.class);
    }

    @Test
    void getByName_returnNull_whenResidenceNotExists() {
        Residence residence = TestUtilsGenerator.getNewResidence();

        Residence foundResidence = residenceRepository.getByName(residence.getResidenceName());

        Assertions.assertThat(foundResidence).isNull();
    }
}
