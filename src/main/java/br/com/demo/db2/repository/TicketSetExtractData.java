package br.com.demo.db2.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

import br.com.demo.db2.domain.Ticket;

public class TicketSetExtractData implements ResultSetExtractor<List<Ticket>> {

	@Override
	public List<Ticket> extractData(ResultSet rs) throws SQLException {
		
		List<Ticket> resultList = new ArrayList<Ticket>();

		while (rs.next()) {
			Ticket t = new Ticket();
			
			t.setNumTicket(rs.getString("NUMTICKET"));
			t.setDescription(rs.getString("DESCRIPTION"));
			t.setEventDate(rs.getString("EVENTDATE"));
			
			resultList.add(t);
		}
				
		return resultList;
	}

	
}
