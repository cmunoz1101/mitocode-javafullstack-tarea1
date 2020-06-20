package com.mitocode.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author cmunoz
 */
@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ModeloNotFoundException.class) // Manejar la excepcion ModeloNotFoundException
    public final ResponseEntity<ExceptionResponse> manejarModeloExcepcion(ModeloNotFoundException ex, WebRequest request) {
        ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
    }
 
    @Override // Este método pertenece a ResponseEntityExceptionHandler y es sobreescrito y controla las validaciones de los campos en las entidades
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String mensaje = "";
        for (ObjectError objectError: ex.getBindingResult().getAllErrors()) {
           mensaje += objectError.getDefaultMessage();
        }
        ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), mensaje, request.getDescription(false));
        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class) // Manejar las demás excepciones
    public final ResponseEntity<ExceptionResponse> manejarExcepcionGeneral(Exception ex, WebRequest request) {
        ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}