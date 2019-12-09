package com.shyam.parkinglot.domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.shyam.parkinglot.service.impl.Command;
import com.shyam.parkinglot.utils.PrintUtils;

public class UploadParkingFile {

	public void createParkingUsingfileInput(String file) {
		String line = null;
		Command command = null;
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			command = new Command();
			while ((line = br.readLine()) != null) {
				command.commandExecutor(line);
			}
		} catch (IOException e) {
			PrintUtils.log(e.getMessage());
		}
	}
}
