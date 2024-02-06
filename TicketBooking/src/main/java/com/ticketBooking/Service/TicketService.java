package com.ticketBooking.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ticketBooking.Entity.Ticket;
import com.ticketBooking.model.ReservationDetails;
import com.ticketBooking.model.TrainDetails;

public interface TicketService {
	
	public String bookingTicket(Ticket ticket);
	
	public Ticket showTicketToUsers(String emailId, String fromLocation, String toLocation, String section);
	
	public Ticket updateExistingTicket(Ticket ticket);
	
	public String deleteExistingTicket(String emailId);
	
	public List<Ticket> getAllTickets();
	
	public TrainDetails getTrainDetails();
	
	public ResponseEntity<ReservationDetails> trainTicketBooking(ReservationDetails reservationDetails);
	
	public ResponseEntity<ReservationDetails> editTicket( ReservationDetails reservationDetails);
	
	public String deleteTicketBySeatNo(long seatNo);

}
