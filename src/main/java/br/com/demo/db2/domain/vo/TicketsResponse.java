package br.com.demo.db2.domain.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TicketsResponse<T> {

	@JsonProperty(value = "data")
	private final List<T> data;
	
	public List<T> getData() {
		return data;
	}
	
	public TicketsResponse(List<T> t) {
		this.data = t;
	}
	
}
