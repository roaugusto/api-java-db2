package br.com.demo.db2.handler;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse implements Serializable{
		
	private static final long serialVersionUID = 1L;

	@JsonProperty("sqlcode")
	private Integer sqlcode;
	
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("message")
	private String message;
	
	public Integer getSqlcode() {
		return sqlcode;
	}

	public void setSqlcode(Integer sqlcode) {
		this.sqlcode = sqlcode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
}
