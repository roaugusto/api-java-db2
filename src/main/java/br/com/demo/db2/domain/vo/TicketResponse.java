package br.com.demo.db2.domain.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TicketResponse<T> {

	@JsonProperty(value = "data")
	private final T data;
	
	public T getData() {
		return data;
	}
	
	public TicketResponse(T t) {
		this.data = t;
	}
	
}
