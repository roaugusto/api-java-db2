package br.com.demo.db2.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class RequestHandler {

	private static final Logger LOG = LoggerFactory.getLogger(RequestHandler.class);

	@ExceptionHandler(value = { BadRequestException.class })
	public ResponseEntity<ErrorHandler> handlerBadRequestException(WebRequest req, BadRequestException e) {
		log(e.getMessage());
		ErrorHandler error = new ErrorHandler(HttpStatus.UNPROCESSABLE_ENTITY.value(), e.getMessage());
		return new ResponseEntity<ErrorHandler>(error, HttpStatus.UNPROCESSABLE_ENTITY);
	}

	private void log(String message) {
		LOG.error(message);
	}
}
