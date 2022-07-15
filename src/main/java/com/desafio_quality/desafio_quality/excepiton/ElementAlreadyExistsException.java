package com.desafio_quality.desafio_quality.excepiton;

import lombok.Getter;

@Getter
public class ElementAlreadyExistsException extends RuntimeException {

    public ElementAlreadyExistsException(){
        super();
    }
}
