package br.com.demo.db2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.demo.db2.domain.Message;
import br.com.demo.db2.domain.Ticket;
import br.com.demo.db2.domain.vo.TicketRequest;
import br.com.demo.db2.domain.vo.TicketResponse;
import br.com.demo.db2.domain.vo.TicketsResponse;
import br.com.demo.db2.repository.TicketRepository;

@SuppressWarnings("unused")
@Service
public class TicketService {

	private TicketRepository ticketRepository;
	
	
	private TicketService(TicketRepository ticketRepository ) {
		this.ticketRepository = ticketRepository;
	}
	
	public TicketResponse<Message> createTicket(TicketRequest parameters) {		
		Message msg = ticketRepository.create(parameters);
		return new TicketResponse<Message>(msg);
	}
	
	public TicketsResponse<Ticket> findAll() {
		
		List<Ticket> tickets = ticketRepository.findAll();
		
		return new TicketsResponse<Ticket>(tickets);		
	}
	
}
