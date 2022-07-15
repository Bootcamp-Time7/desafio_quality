package com.desafio_quality.desafio_quality.excepiton;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ExceptionDetails {
    private String titulo;
    private int status;
    private String mensagem;

}
