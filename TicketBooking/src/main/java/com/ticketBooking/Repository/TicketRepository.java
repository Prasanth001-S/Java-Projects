package com.ticketBooking.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticketBooking.Entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{
	
	List<Ticket> findByUserNameIsNullOrUserName(String username);

}
