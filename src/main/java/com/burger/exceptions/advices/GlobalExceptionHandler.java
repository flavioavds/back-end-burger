package com.burger.exceptions.advices;

import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import com.burger.exceptions.ErrorHandleResponse;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NonUniqueResultException;
import lombok.AllArgsConstructor;

@RestControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler {
	
	private final ErrorHandleResponse errorHandleResponse;
	
	@ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
        String path = ((ServletWebRequest) request).getRequest().getRequestURI();
        Map<String, Object> errorResponse = errorHandleResponse
                .createCustomErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage(), path);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(errorResponse, headers, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(NonUniqueResultException.class)
    public ResponseEntity<Object> handleNonUniqueResultException(NonUniqueResultException ex, WebRequest request) {
        String path = ((ServletWebRequest) request).getRequest().getRequestURI();
        Map<String, Object> errorResponse = errorHandleResponse
                .createCustomErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), path);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(errorResponse, headers, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        String path = ((ServletWebRequest) request).getRequest().getRequestURI();
        Map<String, Object> errorResponse = errorHandleResponse
                .createCustomErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), path);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(errorResponse, headers, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex, WebRequest request) {
        String path = ((ServletWebRequest) request).getRequest().getRequestURI();
        Map<String, Object> errorResponse = errorHandleResponse
                .createCustomErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage(), path);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(errorResponse, headers, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {
        String path = ((ServletWebRequest) request).getRequest().getRequestURI();
        Map<String, Object> errorResponse = errorHandleResponse
                .createCustomErrorResponse(HttpStatus.CONFLICT, ex.getMessage(), path);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(errorResponse, headers, HttpStatus.CONFLICT);
    }
	
	@ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeException(RuntimeException ex, WebRequest request) {
        String path = ((ServletWebRequest) request).getRequest().getRequestURI();
        Map<String, Object> errorResponse = errorHandleResponse
                .createCustomErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), path);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(errorResponse, headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex, WebRequest request) {
	    String path = ((ServletWebRequest) request).getRequest().getRequestURI();
	    Map<String, Object> errorResponse = errorHandleResponse
	            .createCustomErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), path);
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    return new ResponseEntity<>(errorResponse, headers, HttpStatus.BAD_REQUEST);
	}

}
