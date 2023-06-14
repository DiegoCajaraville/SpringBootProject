package com.teleco.gestor_servicios.exceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.teleco.gestor_servicios.dto.DetailedError;

// va a gestionar todas las excepciones de la aplicacion, no de un controller especifico
@ControllerAdvice   
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<DetailedError> manejarResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {

        DetailedError errorDetalles = new DetailedError(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<DetailedError>(errorDetalles, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BlogAppException.class)
    public ResponseEntity<DetailedError> manejarBlogAppException(BlogAppException exception, WebRequest webRequest) {

        DetailedError errorDetalles = new DetailedError(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<DetailedError>(errorDetalles, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<DetailedError> manejarException(Exception exception, WebRequest webRequest) {

        DetailedError errorDetalles = new DetailedError(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<DetailedError>(errorDetalles, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {

            String nombreCampo = ((FieldError) error).getField();
            String mensaje = error.getDefaultMessage();

            errors.put(nombreCampo, mensaje);
        });

        return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
    }
    
}
