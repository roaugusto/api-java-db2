package br.com.demo.db2.domain.vo;

import java.util.Objects;

import br.com.demo.db2.handler.ErrorUtils;

public final class TicketRequest {
	private final String numTicket;
	private final String description;
	private final String eventDate;
	
	private TicketRequest(Builder builder) {
		this.numTicket = builder.numTicket;
		this.description = builder.description;
		this.eventDate = builder.eventDate;	
	}
	
	public static class Builder {
		private String numTicket;
		private String description;
		private String eventDate;
		
		
		public Builder numTicket(String numTicket) {			
			if (Objects.isNull(numTicket)) {
				ErrorUtils.throwMessage("numTicket must not be null");
			}	
			
			this.numTicket = numTicket;
			return this;
		}

		public Builder description(String description) {			
			if (Objects.isNull(description)) {
				ErrorUtils.throwMessage("description must not be null");
			}	
			
			this.description = description;
			return this;
		}

		public Builder eventDate(String eventDate) {			
			if (Objects.isNull(eventDate)) {
				ErrorUtils.throwMessage("eventDate must not be null");
			}	
			
			ValidateUtils.dateTimeIsValid(eventDate, "eventDate");
			
			this.eventDate = eventDate;
			return this;
		}

		public TicketRequest build() {
			return new TicketRequest(this);
		}
		
	}

	public String getNumTicket() {
		return numTicket;
	}

	public String getDescription() {
		return description;
	}

	public String getEventDate() {
		return eventDate;
	}
	
	

}
