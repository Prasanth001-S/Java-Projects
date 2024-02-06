package com.ticketBooking.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ticket_Details")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;

	@Column(name = "From_Location")
	private String fromLocation;

	@Column(name = "To_Location")
	private String toLocation;

	@Column(name = "User_Name")
	private String userName;

	@Column(name = "User_Email_Id")
	private String userEmail;

	@Column(name = "IsPricePaid")
	private boolean pricePaid;

	@Column(name = "Section")
	private String section;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public boolean isPricePaid() {
		return pricePaid;
	}

	public void setPricePaid(boolean pricePaid) {
		this.pricePaid = pricePaid;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}



}
