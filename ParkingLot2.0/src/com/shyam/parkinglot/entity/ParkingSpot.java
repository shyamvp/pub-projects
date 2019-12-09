package com.shyam.parkinglot.entity;

public class ParkingSpot implements Comparable<ParkingSpot>{

	private int number;
	private boolean available;
	private IVehicle vehicle;
	private ParkingSpotType type;

	public enum ParkingSpotType {
		CAR, TRUCK, BUS
	}

	public ParkingSpot(int number) {
		this.number = number;
	}

	public void park(IVehicle vehicle) {
		this.vehicle = vehicle;
		available = false;
	}

	public void leave() {
		this.vehicle = null;
		available = true;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public IVehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(IVehicle vehicle) {
		this.vehicle = vehicle;
	}

	public ParkingSpotType getType() {
		return type;
	}

	public void setType(ParkingSpotType type) {
		this.type = type;
	}

	@Override
	public int compareTo(ParkingSpot o) {
		if(number < o.number) {
			return -1;
		}else if(number > o.number) {
			return 1;
		}
		
		return 0;
	}

	@Override
	public String toString() {
		return "ParkingSpot [number=" + number + ", free=" + available + ", vehicle=" + vehicle + ", type=" + type + "]";
	}
}
