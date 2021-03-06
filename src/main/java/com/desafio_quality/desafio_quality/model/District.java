package com.desafio_quality.desafio_quality.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class District {

    @NotEmpty(message = "O bairro não pode estar vazio")
    @Size(max = 45, message = "O comprimento do bairro não pode exceder 45 caracteres.")
    @Pattern(regexp = "([A-Z]{1}[a-z]+\\s??)+", message = "O nome do bairro deve começar com letra maiúscula")
    private String name;

    @NotNull(message = "O valor do metro quadrado no bairo não pode estar vazio")
    @Digits(integer = 13, fraction = 2)
    private double valuePerSquare;
}
