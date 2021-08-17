package br.com.demo.db2.resource;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.demo.db2.domain.Message;
import br.com.demo.db2.domain.Ticket;
import br.com.demo.db2.domain.vo.TicketRequest;
import br.com.demo.db2.domain.vo.TicketResponse;
import br.com.demo.db2.domain.vo.TicketsResponse;
import br.com.demo.db2.service.TicketService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/tickets")
@Api(value = "/tickets", tags = "tickets")
public class TicketResource {

	private final TicketService ticketService;
	
	private final HttpServletRequest request;
	
	public TicketResource(TicketService ticketService, HttpServletRequest request) {
		this.ticketService = ticketService;
		this.request = request;
	}

	@GetMapping
	public ResponseEntity<TicketsResponse<Ticket>> getAlltickets() {
		
		TicketsResponse<Ticket> response = this.ticketService.findAll();
		
		return ResponseEntity.ok(response);
	}

	@PostMapping
	public ResponseEntity<TicketResponse<Message>> createTicket(@RequestBody Ticket ticket) {

		TicketRequest parameters = new TicketRequest.Builder()
				.numTicket(ticket.getNumTicket())
				.description(ticket.getDescription())
				.eventDate(ticket.getEventDate())
				.build();
		
		TicketResponse<Message> response = this.ticketService.createTicket(parameters);
		
		return ResponseEntity.status(201).body(response);
		
	}

}
