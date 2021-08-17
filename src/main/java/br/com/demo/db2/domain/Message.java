package br.com.demo.db2.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Message {

	private Integer Sqlcode;
	private Integer codMessage;
	private String descrition;
		
	public Integer getCodMessage() {
		return codMessage;
	}

	public void setCodMessage(Integer codMessage) {
		this.codMessage = codMessage;
	}

	public String getDescrition() {
		return descrition;
	}

	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}

	public Integer getSqlcode() {
		return Sqlcode;
	}

	public void setSqlcode(Integer sqlcode) {
		Sqlcode = sqlcode;
	}
	
}
