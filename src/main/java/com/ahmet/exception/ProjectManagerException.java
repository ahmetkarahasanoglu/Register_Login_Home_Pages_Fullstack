package com.ahmet.exception;

import lombok.Getter;

@Getter
public class ProjectManagerException extends RuntimeException {

    private final EErrorType errorType;

    public ProjectManagerException(EErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public ProjectManagerException(EErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

}
