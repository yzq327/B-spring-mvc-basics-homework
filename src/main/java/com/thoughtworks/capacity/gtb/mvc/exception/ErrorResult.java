package com.thoughtworks.capacity.gtb.mvc.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class ErrorResult {
    private  Integer errorCode;
    private String message;

    public ErrorResult(Integer errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public ErrorResult(String message) {
        this.message = message;
    }
}
