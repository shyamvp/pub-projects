package com.shyam.parkinglot.service.impl;

import com.shyam.parkinglot.constants.VehicleType;
import com.shyam.parkinglot.domain.ParkingLot;
import com.shyam.parkinglot.entity.Car;
import com.shyam.parkinglot.entity.ParkingTicket;
import com.shyam.parkinglot.exceptions.ParkingFullException;
import com.shyam.parkinglot.exceptions.ParkingNotFoundException;
import com.shyam.parkinglot.service.IParkingLotService;
import com.shyam.parkinglot.utils.PrintUtils;

public class ParkingLotServiceImpl implements IParkingLotService{

	private ParkingLot parkingLot;
	
	public void createParking(int capacity) {
		
		if(capacity <= 0) {
			throw new NullPointerException("Capacity must be greate than 0.");
		}
		
		parkingLot = ParkingLot.getInstance();
		parkingLot.createParkingLot(capacity);
	}
	
	@Override
	public ParkingTicket park(String regNumber) {
		if(regNumber == null) {
			throw new NullPointerException("Vehicle can not be null.");
		}
		
		parkingLot = ParkingLot.getInstance();
		
		Car car = new Car(VehicleType.CAR);
		car.setRegistrationNumber(regNumber);
		
		ParkingTicket ticket = null;
		try {
			ticket = parkingLot.getNewParkingTicket(car);
		} catch (ParkingFullException e) {
			PrintUtils.log(e.getMessage());
		}
		
		return ticket;
	}

	@Override
	public ParkingTicket leave(String regNumber, int hrs) {
		parkingLot = ParkingLot.getInstance();
		
		try {
			return parkingLot.leave(regNumber, hrs);
		} catch (ParkingNotFoundException e) {
			PrintUtils.log(e.getMessage());
		}
		return null;
	}
	
	@Override
	public void status() {
		parkingLot = ParkingLot.getInstance();
		parkingLot.status();
	}
}
