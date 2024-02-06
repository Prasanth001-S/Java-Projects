package com.ticketBooking.Exception;

public class TicketBookingException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private int statusCode;
	private String description;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public TicketBookingException(int statusCode, String description) {
		super();
		this.statusCode = statusCode;
		this.description = description;
	}
	
	
	
	
}
