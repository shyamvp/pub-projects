package com.shyam.parkinglot.service.impl;

public class PrepareCommand {

	public Command prepareCommand(String commandStr) throws NumberFormatException{
		if(commandStr == null || commandStr.isEmpty()) {
			throw new NullPointerException("parameters should be pass.er");
		}
		
		String[] arr = commandStr.split(" ");
		
		return  null;//new Command(arr[0], arr[1]);
	}
}
