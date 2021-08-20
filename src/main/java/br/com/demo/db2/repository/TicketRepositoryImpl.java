package br.com.demo.db2.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import br.com.demo.db2.domain.Message;
import br.com.demo.db2.domain.Ticket;
import br.com.demo.db2.domain.vo.TicketRequest;
import br.com.demo.db2.handler.BadRequestException;

@Repository("TicketRepository")
class TicketRepositoryImpl implements TicketRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private SimpleJdbcCall simpleJdbcCall;

	@Override
	public Message create(TicketRequest parameters) {

		Message response = new Message();
		
		try {		
			simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
					.withCatalogName("DB2INST1")
			        .withProcedureName("PTICKETS");
			
			SqlParameterSource in = new MapSqlParameterSource()
	                .addValue("IN_NUMTICKET", parameters.getNumTicket())
	                .addValue("IN_DESCRIPTION", parameters.getDescription())
	                .addValue("IN_EVENTDATE", parameters.getEventDate());
			
			
			Map out = simpleJdbcCall.execute(in);
			
			System.out.println("out:" + out);
			
			Integer sqlcode = (Integer) out.get("OUT_SQLCODE");
			Integer code = (Integer) out.get("OUT_CODE");
			String msg = (String) out.get("OUT_MSG=PROCESSAMENTO");
						
			System.out.println("sqlcode:" + sqlcode);
			System.out.println("code:" + code);
			System.out.println("msg:" + msg);
			
			if (sqlcode != 0) {
				response.setSqlcode(sqlcode);
				response.setCodMessage(99);
				response.setDescrition("PROCESSAMENTO NOK");
			}else {
				response.setSqlcode(sqlcode);
				response.setCodMessage(0);
				response.setDescrition("PROCESSAMENTO OK");				
			}
			
			return response;

		} catch (Exception e) {
			throw new BadRequestException(e.getMessage());
		}
	}

	@Override
	public List<Ticket> findAll() {

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT NUMTICKET, DESCRIPTION, EVENTDATE ")
			.append("FROM DBTICKETS");
		
		return this.jdbcTemplate.query(sql.toString(), new TicketSetExtractData());

	}

}
