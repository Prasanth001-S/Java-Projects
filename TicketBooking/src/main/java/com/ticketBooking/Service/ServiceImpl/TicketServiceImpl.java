package com.ticketBooking.Service.ServiceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ticketBooking.Entity.Ticket;
import com.ticketBooking.Exception.TicketBookingException;
import com.ticketBooking.Repository.TicketRepository;
import com.ticketBooking.Service.TicketService;
import com.ticketBooking.model.ReservationDetails;
import com.ticketBooking.model.TrainDetails;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	public String bookingTicket(Ticket ticket) {
		try {
			ticketRepository.save(ticket);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Ticket Booked";
	}

	// Available Seat Details
	public List<Ticket> getAllTickets() {
		return ticketRepository.findByUserNameIsNullOrUserName("");
	}

	public Ticket showTicketToUsers(String emailId, String fromLocation, String toLocation, String section) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Ticket updateExistingTicket(Ticket ticket) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public String deleteExistingTicket(String emailId) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public TrainDetails getTrainDetails() {
		TrainDetails trainDetails = new TrainDetails();
		trainDetails.setTrainName("Express123");
		trainDetails.setDepartureTime(LocalDateTime.now());
		trainDetails.setDestination("France");
		trainDetails.setReachTime(LocalDateTime.now().plusHours(5));
		trainDetails.setTotalSeats(20);

		return trainDetails;
	}

	public ResponseEntity<ReservationDetails> trainTicketBooking(ReservationDetails reservationDetails) {
        Ticket existingTicket = new Ticket();
        try {
            Optional<Ticket> existingTicketOptional = ticketRepository.findById(reservationDetails.getSeatNo());

            if (existingTicketOptional.isPresent()) {
                existingTicket = existingTicketOptional.get();

                existingTicket.setFromLocation(reservationDetails.getFromLocation());
                existingTicket.setToLocation(reservationDetails.getToLocation());
                existingTicket.setPricePaid(true);
                existingTicket.setUserEmail(reservationDetails.getEmailId());
                existingTicket.setUserName(reservationDetails.getUserName());
                if (reservationDetails.getSeatNo() < 10) {
                    existingTicket.setSection("Section-A");
                } else {
                    existingTicket.setSection("Section-B");
                }
                ticketRepository.save(existingTicket);
                return ResponseEntity.ok(reservationDetails); 
            } else {
                throw new TicketBookingException(HttpStatus.NOT_FOUND.value(), "Sorry for Inconvience we are out of tickets");
            }
        } catch (TicketBookingException e) {
            return ResponseEntity.status(e.getStatusCode()).body(reservationDetails); 
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(reservationDetails); 
        }
    }
	
	public ResponseEntity<ReservationDetails> editTicket( ReservationDetails reservationDetails) {
        Ticket existingTicket = ticketRepository.findById(reservationDetails.getSeatNo())
                .orElseThrow(() -> new TicketBookingException(HttpStatus.NOT_FOUND.value(), "Ticket not found"));

        existingTicket.setFromLocation(reservationDetails.getFromLocation());
        existingTicket.setToLocation(reservationDetails.getToLocation());
        existingTicket.setUserEmail(reservationDetails.getEmailId());
        existingTicket.setUserName(reservationDetails.getUserName());
        if (reservationDetails.getSeatNo() < 10) {
            existingTicket.setSection("Section-A");
        } else {
            existingTicket.setSection("Section-B");
        }


        Ticket updatedTicket = ticketRepository.save(existingTicket);

        return ResponseEntity.ok(new ReservationDetails("Ticket updated successfully"));
    }
	
	public String deleteTicketBySeatNo(long seatNo) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(seatNo);
        if (ticketOptional.isPresent()) {
            Ticket ticket = ticketOptional.get();
            ticket.setId(seatNo);
            ticket.setFromLocation("");
            ticket.setToLocation("");
            ticket.setUserName("");
            ticket.setUserEmail("");
            ticket.isPricePaid();
            ticket.setSection("");
            ticketRepository.save(ticket);
        } else {
            throw new TicketBookingException(HttpStatus.NOT_FOUND.value(), "Ticket not found with seat number " + seatNo);
        }
        
        return "Successfully Deleted. Your fund will be Transfer withing 5 working days";
    }

}
