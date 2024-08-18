package com.jamili.ecommerce.config;

import com.jamili.ecommerce.config.exceptions.CustomerAlreadyExistsException;
import com.jamili.ecommerce.config.exceptions.CustumerNotFoundException;
import com.jamili.ecommerce.config.exceptions.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustumerNotFoundException.class)
        public ResponseEntity<Object> handleCustomerNotFoundException(
                CustumerNotFoundException exception, WebRequest request) {
            ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
            return new ResponseEntity<>(errorMessage, new HttpHeaders(), errorMessage.getStatus());
        }

    @ExceptionHandler(CustomerAlreadyExistsException.class)
        public ResponseEntity<Object> handleCustomerAlreadyExistsException(
            CustomerAlreadyExistsException exception, WebRequest request) {
            ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
            return new ResponseEntity<>(errorMessage, new HttpHeaders(), errorMessage.getStatus());
        }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    private Map<String, List<String>> getErrorsMap(List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }
}
