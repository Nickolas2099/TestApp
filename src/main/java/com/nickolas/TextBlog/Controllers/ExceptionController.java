package com.nickolas.TextBlog.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.nickolas.TextBlog.Controllers")
@Slf4j
public class ExceptionController {

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<String> dataExceptionHandler(DataAccessException ex) {
        log.warn("In ExceptionController dataExceptionHandler ", ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> nullExceptionHandler(NullPointerException ex) {
        log.warn("In ExceptionController nullExceptionHandler ", ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> generalExceptionHandler(Exception ex) {
        log.warn("In ExceptionController generalExceptionHandler ", ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
