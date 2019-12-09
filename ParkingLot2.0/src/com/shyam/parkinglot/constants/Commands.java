package com.shyam.parkinglot.constants;

public enum Commands {
	CREATE("create_parking_lot"),
	PARK("park"),
	LEAVE("leave"),
	STATUS("status");
	
	private String command;
	
	Commands(String command) {
		this.command = command;
	}
	
	public final String getCommand() {
		return this.command;
	}
}
