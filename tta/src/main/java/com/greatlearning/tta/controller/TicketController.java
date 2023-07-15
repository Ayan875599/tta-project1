package com.greatlearning.tta.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.tta.entity.Ticket;
import com.greatlearning.tta.service.TicketService;

@Controller
public class TicketController {
	
//	@Autowired
	
	private TicketService ticketService;
	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	
	@GetMapping("/tickets")
	public String listTickets(Model model) {
		
		List<Ticket> ticketsList = ticketService.listAllTickets();
		 
		model.addAttribute("tickets", ticketsList);
		return"tickets";
	}
	
	@GetMapping("/tickets/new")
	
	public String addTicketStep1(Model model) {
		
		Ticket ticket = new Ticket();
		
		//Default values
		
		model.addAttribute("ticket", ticket);
		
		return "add_ticket";
	}
	
	@PostMapping("/tickets")
	
	public String addTicketStep2(
		@ModelAttribute("ticket")
		Ticket ticket) {
		
		ticketService.saveTicket(ticket);
		return "redirect:/tickets";
		
	}
	
	@GetMapping("/tickets/edit/{id}")
	public String editTicketServicStep1(
			@PathVariable
			Long id,Model model) {
		Ticket ticketObj = ticketService.getTicketDetails(id);
		model.addAttribute("ticket", ticketObj);
		return "update_ticket";
			
	}
	
	@PostMapping("/tickets/{id}")
	public String updateTicketStep2(
			@PathVariable Long id,
			@ModelAttribute("ticket")Ticket ticketObjWithUserValues) {
		
	
	
	Ticket existingTicketObjFromDB
	=ticketService.getTicketDetails(id);
	
	
	existingTicketObjFromDB.setTicketTitle(
			ticketObjWithUserValues.getTicketTitle());
	existingTicketObjFromDB.setTicketShortDescription(
			ticketObjWithUserValues.getTicketShortDescription());
	existingTicketObjFromDB.setTicketCreatedon(
			ticketObjWithUserValues.getTicketCreatedon());
	
	ticketService.saveTicket(existingTicketObjFromDB);
	return"redirect:/tickets";
	}
	
	@GetMapping("/tickets/{id}")
	public String deleteTicket(
			@PathVariable Long id) {
		
		ticketService.deleteTicket(id);
		return "redirect:/ticket";
		
	}
	
}