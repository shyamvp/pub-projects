package com.shyam.parkinglot.entity;

import com.shyam.parkinglot.constants.VehicleType;

public interface IVehicle {

	public String getRegistrationNumber();
	public void setRegistrationNumber(String regNumber);
	public String getColor();
	public void setColor(String color);
	public VehicleType getType();
	public void assignTicket(ParkingTicket ticket);
	public ParkingTicket getTicket();
}
