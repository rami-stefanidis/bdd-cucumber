package com.rami.advice;

import com.rami.exception.RestServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserControllerAdvice {


    @ExceptionHandler(RestServiceException.class)
    public ResponseEntity<String> handleRestServiceException(RestServiceException rse) {
        return new ResponseEntity<>(rse.getReason(),HttpStatus.FORBIDDEN);
    }
}
