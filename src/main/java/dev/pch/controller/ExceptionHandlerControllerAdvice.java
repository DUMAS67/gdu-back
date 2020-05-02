package dev.pch.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import dev.pch.exception.BadRequestException;
import dev.pch.exception.ElementNotFoundException;
import dev.pch.exception.ForbiddenOperationException;

/*
 * Permet de gérer les exceptions retournés par les controleurs 
 */
@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {

	private static final Logger LOG = LoggerFactory.getLogger(ExceptionHandlerControllerAdvice.class);

	/**
	 * Gestion des erreurs
	 */
	@ExceptionHandler(value = { ElementNotFoundException.class })
	public ResponseEntity<String> onNotFound(ElementNotFoundException exception) {
		LOG.error(exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}

	@ExceptionHandler(value = { BadRequestException.class })
	public ResponseEntity<String> onBadRequest(BadRequestException exception) {
		LOG.error(exception.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
	}

	@ExceptionHandler(value = { ForbiddenOperationException.class })
	public ResponseEntity<String> onForbiddenOperation(ForbiddenOperationException exception) {
		LOG.error(exception.getMessage());
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exception.getMessage());
	}

}
