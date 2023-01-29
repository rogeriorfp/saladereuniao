package com.digital.crud.saladereuniao.saladereuniao.exception;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetails {
    private OffsetDateTime timestamp;
    private String message;
    private String details;
}
