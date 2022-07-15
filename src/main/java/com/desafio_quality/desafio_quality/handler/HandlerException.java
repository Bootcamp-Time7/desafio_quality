package com.desafio_quality.desafio_quality.handler;

import com.desafio_quality.desafio_quality.excepiton.ElementAlreadyExistsException;
import com.desafio_quality.desafio_quality.excepiton.ExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerException extends Throwable{

    @ExceptionHandler(ElementAlreadyExistsException.class)
    public ResponseEntity<ExceptionDetails> exceptionHandler(ElementAlreadyExistsException ex) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .titulo("Elemento já existe no banco de dados")
                        .status(HttpStatus.FOUND.value())
                        .mensagem(HttpStatus.FOUND.name())
                        .build(), HttpStatus.FOUND
        );
    }
}
