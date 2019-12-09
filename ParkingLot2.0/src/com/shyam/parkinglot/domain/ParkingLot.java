package com.shyam.parkinglot.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

import com.shyam.parkinglot.constants.ParkingTicketStatus;
import com.shyam.parkinglot.constants.VehicleType;
import com.shyam.parkinglot.entity.IVehicle;
import com.shyam.parkinglot.entity.ParkingSpot;
import com.shyam.parkinglot.entity.ParkingTicket;
import com.shyam.parkinglot.exceptions.ParkingFullException;
import com.shyam.parkinglot.exceptions.ParkingNotFoundException;
import com.shyam.parkinglot.utils.PrintUtils;

public class ParkingLot {

	private int carSpotCount = 0;
	private int maxCarCount = 0;
	private Queue<ParkingSpot> spots;
	
	private Map<String, ParkingTicket> activeTickets;

	private static ParkingLot parkingLot = null;

	private ParkingLot() {
		if(parkingLot != null) {
			throw new RuntimeException("Kindly use getInstance method to create instance.");
		}
	}

	public static ParkingLot getInstance() {
		if (parkingLot == null) {
			parkingLot = new ParkingLot();
		}
		return parkingLot;
	}

	public synchronized ParkingTicket getNewParkingTicket(IVehicle vehicle) throws ParkingFullException {
		
		if(maxCarCount == 0) {
			throw new RuntimeException("Create parking lot before get parking ticket.");
		}
		
		if (this.isFull(vehicle.getType())) {
			throw new ParkingFullException("Sorry, parking lot is full");
		}
		
		ParkingSpot spot = spots.remove();
		spot.setVehicle(vehicle);
		spot.setAvailable(false);
		
		ParkingTicket ticket = new ParkingTicket();
		vehicle.assignTicket(ticket);
		ticket.setIssuedAt(new Date());
		ticket.setParkingTicketNumber(new Random().nextLong());
		ticket.setStatus(ParkingTicketStatus.PARK);
		ticket.setSpot(spot);
		ticket.save();
		
		this.incrementSpotCount(vehicle.getType());
		this.activeTickets.put(vehicle.getRegistrationNumber(), ticket);
		
		PrintUtils.log(String.format("Allocated slot number:%d", spot.getNumber()));
		
		return ticket;
	}

	public boolean isFull(VehicleType type) {
		if (type == VehicleType.CAR) {
			return carSpotCount >= maxCarCount;
		}

		return false;
	}

	private void incrementSpotCount(VehicleType type) {
		if (type == VehicleType.CAR) {
			carSpotCount++;
		}
	}
	
	public synchronized void createParkingLot(int capacity) {
		this.maxCarCount = capacity;
		activeTickets = new HashMap<>(capacity);
		spots = new LinkedList<>();
		
		ParkingSpot  spot = null;
		for(int i=1; i<=capacity; i++) {
			spot = new ParkingSpot(i);
			spot.setAvailable(true);
			spots.add(spot);
		}
		
		PrintUtils.log(String.format("Created parking lot with %d slots", capacity));
	}
	
	public ParkingTicket leave(String regNumber, int hrs) throws ParkingNotFoundException {
		ParkingTicket ticket = activeTickets.get(regNumber);
		
		if(ticket == null) {
			throw new ParkingNotFoundException(String.format("Registration number %s not found", regNumber));
		}
		
		double amount = 0;
		
		if(hrs > 1) {
			amount = (hrs - 2) * 10 + 10; 
		}else {
			amount = 10;
		}
		ticket.setAmount(amount);
		ticket.setPayedAt(new Date());
		ticket.setStatus(ParkingTicketStatus.LEAVE);
		
		ParkingSpot spot = ticket.getSpot();
		spot.setType(null);
		spot.setAvailable(true);
		spots.add(spot);
		
		carSpotCount--;
		
		PrintUtils.log(String.format("Registration number %s with Slot Number %d is free with Charge %f", regNumber, ticket.getSpot().getNumber() ,amount));
		
		return ticket;
	}
	
	public void status () {
		PrintUtils.printParkingDashBord(activeTickets);
	}
}
