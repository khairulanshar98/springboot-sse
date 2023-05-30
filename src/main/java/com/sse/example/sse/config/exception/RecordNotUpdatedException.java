package com.sse.example.sse.config.exception;

public class RecordNotUpdatedException extends Exception {
    public RecordNotUpdatedException() {
        super();
    }

    public RecordNotUpdatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public RecordNotUpdatedException(String message) {
        super(message);
    }

    public RecordNotUpdatedException(Throwable cause) {
        super(cause);
    }
}
