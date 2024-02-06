package com.ticketBooking.model;

import java.time.LocalDateTime;

public class TrainDetails {
	
	private String trainName;
	
    public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public LocalDateTime getReachTime() {
		return reachTime;
	}
	public void setReachTime(LocalDateTime reachTime) {
		this.reachTime = reachTime;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	private LocalDateTime departureTime;
    private String destination;
    private LocalDateTime reachTime;
    private int totalSeats;

}
