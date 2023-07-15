package com.greatlearning.tta.service;
import java.util.List;

import com.greatlearning.tta.entity.Ticket;
public interface TicketService {
	List<Ticket> listAllTickets();
	void saveTicket(Ticket ticket);
	Ticket getTicketDetails(Long id);
	void deleteTicket(Long id);
}
