package com.nagarjun.cts.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MovieNotFoundHandler {
	@ResponseBody
	@ExceptionHandler(MovieNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String movieNotFoundHandler(MovieNotFoundException ex) {
		return ex.getMessage();
	}
}
