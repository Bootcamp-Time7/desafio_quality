package com.desafio_quality.desafio_quality.excepiton;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ValidationDetails {
    private final String message;
    private final int code;
    private final String status;
    private final String objectName;
    private final List<ErrorObject> errors;
}
