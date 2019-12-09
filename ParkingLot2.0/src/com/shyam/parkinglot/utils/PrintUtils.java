package com.shyam.parkinglot.utils;

import java.util.Map;

import com.shyam.parkinglot.entity.ParkingTicket;

public class PrintUtils {

	public static void printCommandUsage() {
		System.out.println("Usage :");
		System.out.println(String.format("Create parking lot of size n %s", ": create_parking_lot {capacity}"));
		System.out.println(String.format("Park a car %37s", ": park {car_number}"));
		System.out.println(String.format("Remove(Unpark) car from %33s", ": leave {car_number} {hours}"));
		System.out.println(String.format("Print status of parking slot %s", ": status"));
		
		System.out.println("Please Enter 'exit' to end Execution");
		System.out.println("Input:");
	}

	public static void printParkingDashBord(Map<String, ParkingTicket> activeTickets) {
		System.out.println("Slot No. Registration No.");
		activeTickets.forEach((k,v) -> {
			System.out.println(String.format("%s %s", v.getStatus(), k));
		});
	}
	
	public static void log(String log) {
		System.out.println(log);
	}
}
