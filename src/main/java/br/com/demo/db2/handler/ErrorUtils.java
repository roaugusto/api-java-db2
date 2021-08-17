package br.com.demo.db2.handler;

public final class ErrorUtils {

	private static final String INVALID_VALUE = "Invalid value for %s: %s";
	
	private ErrorUtils() {}
	
	public static void throwMessage(String message) {		
		throw new BadRequestException(message);
	}

	public static BadRequestException illegalArgumentInvalidValue(String paramName, Object value) {
		throw new BadRequestException(String.format(INVALID_VALUE, paramName, value));
	}
	
	
}
