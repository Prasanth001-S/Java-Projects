package com.ticketBooking.model;

public class ReservationDetails {

	private Long seatNo;

	private String fromLocation;

	private String toLocation;

	private Boolean priceDetails;

	private String userName;

	private String emailId;


	public ReservationDetails(String string) {
		// TODO Auto-generated constructor stub
	}

	public ReservationDetails() {
		// TODO Auto-generated constructor stub
	}

	public Long getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(Long seatNo) {
		this.seatNo = seatNo;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public Boolean getPriceDetails() {
		return priceDetails;
	}

	public void setPriceDetails(Boolean priceDetails) {
		this.priceDetails = priceDetails;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
