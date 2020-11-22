package com.nagarjun.cts.Exception;

import lombok.extern.java.Log;

@Log
public class MovieNotFoundException extends RuntimeException {
	public MovieNotFoundException(Integer id) {
		super("Could not found movie :" + id);
		log.info("INSIDE MovieNotFoundException()");

	}
}
