package br.com.demo.db2.domain.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;

import br.com.demo.db2.handler.ErrorUtils;

public class ValidateUtils {
	
	private ValidateUtils() {}

	public static LocalDateTime dateTimeIsValid(String dateTime, String paramName) {
		try {
			LocalDateTime localDateTime = null;
			if(StringUtils.isNotBlank(dateTime)) {
				DateTimeFormatter fd = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss.SSSSSS");
				localDateTime = LocalDateTime.parse(dateTime, fd);	
			}
			return localDateTime;
		}catch (Exception e) {
			throw ErrorUtils.illegalArgumentInvalidValue(paramName, "The format must be: yyyy-MM-dd-HH.mm.ss.SSSSSS");
		}
	}
	

}
