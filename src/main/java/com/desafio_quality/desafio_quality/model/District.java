package com.desafio_quality.desafio_quality.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.*;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class District {

    @NotBlank (message = "O bairro não pode estar vazio")
    @Size(max = 45, message = "O comprimento do bairro não pode exceder 45 caracteres.")
    private String name;

    @NotBlank (message = "O valor do metro quadrado no bairo não pode estar vazio")
    @Digits(integer = 13, fraction = 2)
    private double valuePerSquare;
}
