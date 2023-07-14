package com.nickolas.TextBlog.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler
    public ResponseEntity<String> generalException(Exception ex) {
        return ResponseEntity.status(HttpStatus.OK).body(ex.getMessage());
    }

}
