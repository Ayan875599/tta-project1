package com.greatlearning.tta.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tickets")

public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "TICKET_TITLE")
	private String ticketTitle;
	@Column(name = "TICKET_SHORT_DESCRIPTION")
	private String ticketShortDescription;
	@Column(name ="TICKET_CREATEDon")
	private String ticketCreatedon;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getTicketTitle() {
		return ticketTitle;
	}
	public void setTicketTitle(String ticketTitle) {
		this.ticketTitle = ticketTitle;
	}
	public String getTicketShortDescription() {
		return ticketShortDescription;
	}
	public void setTicketShortDescription(String ticketShortDescription) {
		this.ticketShortDescription = ticketShortDescription;
	}
	public String getTicketCreatedon() {
		return ticketCreatedon;
	}
	public void setTicketCreatedon(String ticketCreatedon) {
		this.ticketCreatedon = ticketCreatedon;
	}

}
