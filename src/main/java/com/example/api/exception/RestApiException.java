package com.example.api.exception;

public class RestApiException extends RuntimeException {
    public RestApiException(String message) { //в конструктор передаем только message
        super(message);
    }
}
