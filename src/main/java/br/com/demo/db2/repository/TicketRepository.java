package br.com.demo.db2.repository;

import java.util.List;

import br.com.demo.db2.domain.Message;
import br.com.demo.db2.domain.Ticket;
import br.com.demo.db2.domain.vo.TicketRequest;

public interface TicketRepository  {
	
	Message create(TicketRequest parameters);
	
	List<Ticket> findAll();
}

