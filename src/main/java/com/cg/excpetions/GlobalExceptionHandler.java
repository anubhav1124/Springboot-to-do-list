package com.cg.excpetions;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = TaskDetailsNotFoundException.class)
	public ResponseEntity<Object> exceptionHandler(Exception ex) {

		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = TaskIdNotFoundException.class)
	public ResponseEntity<Object> exceptionHandler1(Exception ex) {

		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMyException(MethodArgumentNotValidException ex) {
		Map<String, String> m = new LinkedHashMap<>();
		List<ObjectError> oerrors = ex.getAllErrors();
		oerrors.forEach(obj -> {
			FieldError ferror = (FieldError) obj;
			String fname = ferror.getField();
			String message = ferror.getDefaultMessage();
			m.put(fname, message);
		});
		ResponseEntity<Map<String, String>> re = new ResponseEntity<Map<String, String>>(m, HttpStatus.BAD_REQUEST);
		return re;
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> handleMyException5(ConstraintViolationException ex) {
		String s = ex.getMessage();
		ResponseEntity<String> re = new ResponseEntity<String>(s, HttpStatus.BAD_REQUEST);
		return re;
	}

}
