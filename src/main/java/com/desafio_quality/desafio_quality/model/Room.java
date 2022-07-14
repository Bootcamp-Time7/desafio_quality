package com.desafio_quality.desafio_quality.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @NotBlank(message = "O campo não pode estar vazio")
    @Pattern(regexp = "([A-Z]{1}[a-z]+\\s??)+", message = "O nome do cômodo deve começar com letra maiúscula")
    @Size(max = 30, message = "O comprimento do cômodo não pode exceder 30 caracteres.")
    private String roomName;

    @NotBlank(message = "A largura do cômodo não pode estar vazia")
    @Size(max = 25, message = "A largura máxima permitida por cômodo é de 25 metros.")
    private double roomWidth;

    @NotBlank(message = "O comprimento do cômodo não pode estar vazio")
    @Size(max = 33, message = "O comprimento máximo permitido por cômodo é de 33 metros.")
    private double roomLength;

    public static Double SquareRoom(Room room) {
        Double roomSquare;
        roomSquare= room.getRoomLength()*room.getRoomLength();
        return roomSquare;
    }
}
