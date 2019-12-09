package com.shyam.parkinglot.entity;

import com.shyam.parkinglot.constants.VehicleType;

public class Car implements IVehicle {

	public String registrationNumber;
	public String color;
	public ParkingTicket ticket;
	public VehicleType type;
	
	public Car(VehicleType type) {
		this.type = type;
	}
	
	@Override
	public String getRegistrationNumber() {
		return this.registrationNumber;
	}
	
	@Override
	public void setRegistrationNumber(String regNumber) {
		this.registrationNumber = regNumber;
	}
	@Override
	public String getColor() {
		return this.color;
	}
	
	@Override
	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public VehicleType getType() {
		return this.type;
	}
	
	@Override
	public void assignTicket(ParkingTicket ticket) {
		this.ticket = ticket;
	}
	
	@Override
	public ParkingTicket getTicket() {
		return this.ticket;
	}
}
