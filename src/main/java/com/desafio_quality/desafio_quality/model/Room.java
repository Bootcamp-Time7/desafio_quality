package com.desafio_quality.desafio_quality.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @NotEmpty(message = "O campo não pode estar vazio")
    @Pattern(regexp = "([A-Z]{1}[a-z]+\\s??)+", message = "O nome do cômodo deve começar com letra maiúscula")
    @Size(max = 30, message = "O comprimento do cômodo não pode exceder 30 caracteres.")
    private String roomName;

    @NotNull(message = "A largura do cômodo não pode estar vazia")
    @DecimalMax(value = "25", message = "A largura máxima permitida por cômodo é de 25 metros.")
    private double roomWidth;

    @NotNull(message = "O comprimento do cômodo não pode estar vazio")
    @DecimalMax( value= "33.0", message = "O comprimento máximo permitido por cômodo é de 33 metros.")
    private double roomLength;


    public static Double calculateArea(Room room) {
        return  room.getRoomLength()*room.getRoomWidth();
    }
}
