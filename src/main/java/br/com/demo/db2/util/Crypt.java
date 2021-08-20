package br.com.demo.db2.util;

import java.util.Base64;

public class Crypt {

	public static String Encode(String decodedString) {
		String encodedString = Base64.getEncoder().encodeToString(decodedString.getBytes());
		return encodedString;
	}

	public static String Decode(String encodedString) {		
		byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
		String decodedString = new String(decodedBytes);		
		return decodedString;
	}

}
