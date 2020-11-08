package com.thoughtworks.capacity.gtb.mvc.exception;


public class UserNotFoundException extends RuntimeException {

    private ErrorResult errorResult;
    public UserNotFoundException(Integer errorCode, String message) {
        errorResult = new ErrorResult(errorCode,message);
    }

    public ErrorResult getErrorResult() {
        return errorResult;
    }

}