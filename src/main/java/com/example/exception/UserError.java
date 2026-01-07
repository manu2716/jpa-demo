package com.example.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserError {

    private int status;
    private String message;
}
