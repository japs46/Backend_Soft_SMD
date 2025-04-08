package com.japs.backend.supermercado.pos.infrastructure.entry_points.restconsumer.exceptionhandler;

import com.japs.backend.supermercado.pos.application.response.ErrorResponse;
import com.japs.backend.supermercado.pos.application.response.Errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST) // Devuelve un 400 Bad Request
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
		List<Errors> errorsList = new ArrayList<>();
		
		ex.getBindingResult().getAllErrors().forEach(error ->{
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errorsList.add(Errors.builder().field(fieldName).errorMessage(errorMessage).build());
		});

		ErrorResponse errorResponse = ErrorResponse.builder()
				.message("Validacion Fallida")
				.errors(errorsList)
				.build();

		return ResponseEntity.badRequest().body(errorResponse);
    }
	
	@ResponseStatus(HttpStatus.BAD_REQUEST) // Devuelve un 400 Bad Request
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public String handleValidationExceptions2(HttpMessageNotReadableException ex) {
		return "No hay cuerpo de solicitud";
    }

}