package com.shyam.parkinglot.service;

import javax.management.ReflectionException;

import com.shyam.parkinglot.entity.ParkingTicket;
import com.shyam.parkinglot.exceptions.ParkingFullException;

public interface IParkingLotService {

	public ParkingTicket park(String regNumber) throws ParkingFullException, ReflectionException;
	public ParkingTicket leave(String regNumber, int hrs);
	void status();
	public void createParking(int parseInt);
}
