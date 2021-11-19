package ro.example.online.shop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ro.example.online.shop.api.model.generated.Errors;
import ro.example.online.shop.exception.OnlineShopException;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(OnlineShopException.class)
    public ResponseEntity<Errors> handleValidationException(Exception exception) {
        log.error("Bad request: {}", exception.getMessage());

        var errors = new Errors().error(exception.getMessage()).code(HttpStatus.INTERNAL_SERVER_ERROR.toString());

        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .contentType(MediaType.APPLICATION_JSON)
            .body(errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Errors> handleException(Exception ex) {
        log.error("Generic error", ex);

        var errors = new Errors().error("Internal server error").code(HttpStatus.INTERNAL_SERVER_ERROR.toString());

        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .contentType(MediaType.APPLICATION_JSON)
            .body(errors);
    }
}

