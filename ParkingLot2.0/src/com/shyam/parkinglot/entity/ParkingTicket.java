package com.shyam.parkinglot.entity;

import java.util.Date;

import com.shyam.parkinglot.constants.ParkingTicketStatus;

public class ParkingTicket {

	private long parkingTicketNumber;
	private Date issuedAt;
	private Date payedAt;
	private ParkingTicketStatus status;
	private ParkingSpot spot;
	private double amount;
	
	public long getParkingTicketNumber() {
		return parkingTicketNumber;
	}
	
	public void setParkingTicketNumber(long parkingTicketNumber) {
		this.parkingTicketNumber = parkingTicketNumber;
	}
	
	public Date getIssuedAt() {
		return issuedAt;
	}
	
	public void setIssuedAt(Date issuedAt) {
		this.issuedAt = issuedAt;
	}
	
	public Date getPayedAt() {
		return payedAt;
	}
	
	public void setPayedAt(Date payedAt) {
		this.payedAt = payedAt;
	}
	
	public ParkingTicketStatus isStatus() {
		return status;
	}
	
	public void setStatus(ParkingTicketStatus status) {
		this.status = status;
	}

	public void save() {
		// save in DB/File
	}

	public ParkingSpot getSpot() {
		return spot;
	}

	public void setSpot(ParkingSpot spot) {
		this.spot = spot;
	}

	public ParkingTicketStatus getStatus() {
		return status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ParkingTicket [parkingTicketNumber=" + parkingTicketNumber + ", issuedAt=" + issuedAt + ", payedAt="
				+ payedAt + ", status=" + status + ", spot=" + spot + ", amount=" + amount + "]";
	}
}	
