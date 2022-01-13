package com.unibuc.books_reviews.exceptionHandling;

import com.unibuc.books_reviews.exceptions.BadValueForRatingException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BadValueForRatingException.class})
    public ResponseEntity<Map<String, String>> handleException(RuntimeException exception){
        Map<String, String> responseParameters = new HashMap<>();
        responseParameters.put("Reason: ", exception.getMessage());
        responseParameters.put("DateTime: ", LocalDateTime.now().toString());

        return ResponseEntity.badRequest().body(responseParameters);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleApiValidationForClasses(MethodArgumentNotValidException exception){
        Map<String, Object> responseParameters = new HashMap<>();
        List<String> errors = exception.getBindingResult().getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        responseParameters.put("Reason: ", errors);
        responseParameters.put("DateTime: ", LocalDateTime.now().toString());

        return ResponseEntity.badRequest().body(responseParameters);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, Object>> handleApiValidationForParameters(ConstraintViolationException exception){
        Map<String, Object> responseParameters = new HashMap<>();
        List<String> errors = exception.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());

        responseParameters.put("Reason: ", errors);
        responseParameters.put("DateTime: ", LocalDateTime.now().toString());

        return ResponseEntity.badRequest().body(responseParameters);
    }

}