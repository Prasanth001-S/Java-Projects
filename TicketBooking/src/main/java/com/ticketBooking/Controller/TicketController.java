package com.ticketBooking.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ticketBooking.Entity.Ticket;
import com.ticketBooking.Exception.TicketBookingException;
import com.ticketBooking.Service.TicketService;
import com.ticketBooking.model.ReservationDetails;
import com.ticketBooking.model.TrainDetails;

@RestController
public class TicketController {
	
	@Autowired
	private TicketService ticketServie;
	
	@PostMapping("/ticketAddingByAdmin")
	public ResponseEntity<String> bookingTicket(@RequestBody Ticket ticket){
		String message = null;
		try {
			message = ticketServie.bookingTicket(ticket);
		}catch(Exception exe) {
			exe.printStackTrace();
		}
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	
	 @GetMapping("/allAvailableTicketDetails")
	    public ResponseEntity<List<Ticket>> getAllTickets() {
		 List<Ticket> list = new ArrayList<>();
			try {
				list = ticketServie.getAllTickets();
			}catch(Exception exe) {
				exe.printStackTrace();
			}
			return new ResponseEntity<List<Ticket>>(list, HttpStatus.OK);
	    }
	 
	 @GetMapping("/trainDetails")
	    public ResponseEntity<TrainDetails> getTrainDetails() {
		 TrainDetails trainDetails = new TrainDetails();
		 try {
			 trainDetails = ticketServie.getTrainDetails();
		 }catch(Exception exe) {
			 exe.printStackTrace();
		 }
		 return new ResponseEntity<TrainDetails>(trainDetails, HttpStatus.OK);
	    }
	 
	  @PostMapping("/bookTrainTicket")
	    public ResponseEntity<ReservationDetails> bookTrainTicket(@RequestBody ReservationDetails reservationDetails) {
	        try {
	            ResponseEntity<ReservationDetails> bookingTicket = ticketServie.trainTicketBooking(reservationDetails);
	            return bookingTicket;
	        } catch (TicketBookingException e) {
	            // If the exception is due to unavailability of tickets, return appropriate response
	            if (e.getStatusCode() == HttpStatus.NOT_FOUND.value()) {
	                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ReservationDetails("Sorry for Inconvenience we are out of tickets")); 
	            }
	            // For other exceptions, return internal server error
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ReservationDetails("Internal Server Error"));
	        }
	    }
	  
	  @PutMapping("/editTicket")
	    public ResponseEntity<String> editTicket(@RequestBody ReservationDetails reservationDetails) {
		  ResponseEntity<ReservationDetails> editedTicket = null;
	        try {
	       editedTicket = ticketServie.editTicket( reservationDetails);
	            
	        } catch (TicketBookingException e) {
	            e.printStackTrace();
	        }
	        return new ResponseEntity<String>("Successfully Updated", HttpStatus.ACCEPTED);
	    }
	  
	  @DeleteMapping("/deleteBySeatNumber/{seatNo}")
	  public ResponseEntity<String> deleteBySeatNumber(@PathVariable Long seatNo){
		  String message = new String ();
		  try {
			  message = ticketServie.deleteTicketBySeatNo(seatNo);
		  }catch(Exception exe) {
			  exe.printStackTrace();
		  }
		  return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);
	  }
	
	}
