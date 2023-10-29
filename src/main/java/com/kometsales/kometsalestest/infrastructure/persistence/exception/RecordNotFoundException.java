package com.kometsales.kometsalestest.infrastructure.persistence.exception;

public class RecordNotFoundException extends RuntimeException {

    public RecordNotFoundException(String message) {
        super(message);
    }

    public RecordNotFoundException(String message, Throwable tw) {
        super(message, tw);

    }
}
