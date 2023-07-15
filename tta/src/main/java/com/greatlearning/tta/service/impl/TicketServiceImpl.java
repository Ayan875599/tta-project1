package com.greatlearning.tta.service.impl;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.tta.entity.Ticket;
import com.greatlearning.tta.repository.TicketRepository;
import com.greatlearning.tta.service.TicketService;


@Service
public class TicketServiceImpl 
	implements TicketService{
	
//	@Autowired
	private TicketRepository ticketRepository;
	
	public TicketServiceImpl(TicketRepository ticketRepository) {
		
		this.ticketRepository = ticketRepository;
	}
	
	@Override
	public List<Ticket> listAllTickets(){
		return ticketRepository.findAll();
	}
	
	@Override
	public void saveTicket(Ticket ticket) {
		ticketRepository.save(ticket);
		
	}
	
	@Override
	public Ticket getTicketDetails(Long id) {
		return ticketRepository.findById(id).get();
	}
	@Override
	public void deleteTicket(Long id) {
		ticketRepository.deleteById(id);
	}
}