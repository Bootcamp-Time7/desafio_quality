package com.desafio_quality.desafio_quality.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Residence {

    @NotEmpty(message = "O nome da propriedade não pode estar vazio")
    @Pattern(regexp = "([A-Z]{1}[a-z]+\\s??)+", message = "O nome da propriedade deve começar com letra maiúscula")
    @Size(max = 30, message = "O comprimento do nome não pode exceder 30 caracteres.")
    private String residenceName;

    @NotNull(message = "O nome do bairro não pode estar vazio")
    private District residenceDistrict;

    @NotEmpty(message = "A lista de cômodos não pode estar vazia")
    private List<@Valid Room> listRooms;

}
