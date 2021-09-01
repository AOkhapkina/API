package com.example.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestApiExceptionHandler {

    @ExceptionHandler(RestApiException.class)
    //в скобках можно перечислить сразу несколько типов исключений через .class
    public ResponseEntity<Object> handleException(Exception e) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(e.getMessage(), status);

    }
}


//Основной недостаток @ExceptionHandler в том что он определяется для каждого контроллера отдельно,
//а не глобально для всего приложения, но в аннотации @ExceptionHandler в скобках можно перечислить сразу несколько типов исключений.
//Сама обработка исключения в данном случае примитивная и сделана просто для демонстрации работы метода — по сути вернётся код 200 и JSON с описанием ошибки. На практике часто требуется более сложная логика обработки и если нужно вернуть другой код статуса,
// то можно воспользоваться дополнительно аннотацией @ResponseStatus, например @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR).