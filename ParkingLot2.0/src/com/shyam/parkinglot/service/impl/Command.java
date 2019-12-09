package com.shyam.parkinglot.service.impl;

import javax.management.ReflectionException;

import com.shyam.parkinglot.domain.ParkingLot;
import com.shyam.parkinglot.exceptions.ParkingFullException;
import com.shyam.parkinglot.service.IParkingLotService;
import com.shyam.parkinglot.utils.PrintUtils;

public class Command {

	public void commandExecutor(String command) {
		try {
			if (command.equalsIgnoreCase("exit")) {
				PrintUtils.log("Existed successfully.");
			} else {
				IParkingLotService ps = new ParkingLotServiceImpl();
				String[] arg = command.split(" ");

				switch (arg[0]) {
				case "create_parking_lot":
					evaluateCreateParkingFunction(arg, ps);
					break;

				case "park":
					evaluateParkFunction(arg, ps);
					break;

				case "leave":
					evaluateLeaveFunction(arg, ps);
					break;

				case "status":
					evaluateStatusFunction(ps);
					break;
				default:
					PrintUtils.printCommandUsage();
					break;
				}
			}
		} catch (Exception e) {
			PrintUtils.log(e.getMessage());
		}
	}

	public void evaluateCreateParkingFunction(String[] args, IParkingLotService ps) {
		if (args.length == 2)
			ps.createParking(Integer.parseInt(args[1]));
	}

	public void evaluateParkFunction(String[] args, IParkingLotService ps) throws ParkingFullException, ReflectionException {
		if (args.length == 2)
			ps.park(args[1]);
	}

	public void evaluateLeaveFunction(String[] args, IParkingLotService ps) {
		if (args.length == 3)
			ps.leave(args[1], Integer.parseInt(args[2]));
	}

	public void evaluateStatusFunction(IParkingLotService ps) {
		ps.status();
	}
}
