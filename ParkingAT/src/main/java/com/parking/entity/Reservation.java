package com.parking.entity;

import java.sql.Date;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Reservation {
	private String ReservationID;
    private String userID;
    private Date checkIn;
    private Date checkOut;
    private String paymentId;
    //private boolean Cancellation;
    private String GarageID;
    private boolean isPaid;
    private String spots;
    private double price;
    
	public String getReservationID() {
		return ReservationID;
	}
	public void setReservationID(String reservationID) {
		ReservationID = reservationID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String customerID) {
		userID = customerID;
	}
	public Date getStartTime() {
		return checkIn;
	}
	public void setStartTime(Date checkin) {
		checkIn = checkin;
	}
	public Date getEndTime() {
		return checkOut;
	}
	public void setEndTime(Date time) {
		checkOut= time;
	}
	
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getGarageID() {
		return GarageID;
	}
	public void setGarageID(String garageID) {
		GarageID = garageID;
	}
	public boolean getPaid() {
		return isPaid;
	}
	public void setPaid(boolean paid) {
		isPaid = paid;
	}
	public void setSpots(String spot){
		spots = spot;
	}
	public String getSpots(){
		return spots;
	}
}
