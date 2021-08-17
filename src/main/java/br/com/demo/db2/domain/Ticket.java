package br.com.demo.db2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Ticket {

	@JsonProperty("numTicket")
	private String numTicket;

	@JsonProperty("description")
	private String description;

	@JsonProperty("eventDate")
	private String eventDate;

	public Ticket(String numTicket, String description) {
		this.numTicket = numTicket;
		this.description = description;
	}

	public String getNumTicket() {
		return numTicket;
	}

	public void setNumTicket(String numTicket) {
		this.numTicket = numTicket;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

}
