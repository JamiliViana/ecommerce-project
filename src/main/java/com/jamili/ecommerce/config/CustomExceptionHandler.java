package com.jamili.ecommerce.config;

import com.jamili.ecommerce.config.exceptions.CustumerNotFoundException;
import com.jamili.ecommerce.config.exceptions.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustumerNotFoundException.class)
        public ResponseEntity<Object> handleCustomerNotFoundException(
                CustumerNotFoundException exception, WebRequest request) {

            ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());

            return new ResponseEntity<>(errorMessage, new HttpHeaders(), errorMessage.getStatus());
        }
}
