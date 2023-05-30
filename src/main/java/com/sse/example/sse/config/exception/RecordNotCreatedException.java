package com.sse.example.sse.config.exception;

public class RecordNotCreatedException extends Exception {
    public RecordNotCreatedException() {
        super();
    }

    public RecordNotCreatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public RecordNotCreatedException(String message) {
        super(message);
    }

    public RecordNotCreatedException(Throwable cause) {
        super(cause);
    }
}
