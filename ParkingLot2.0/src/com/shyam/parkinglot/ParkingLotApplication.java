package com.shyam.parkinglot;

import com.shyam.parkinglot.domain.UploadParkingFile;
import com.shyam.parkinglot.utils.PrintUtils;

public class ParkingLotApplication {

	public static void main(String[] args) {
		
		if(args.length == 1) {
			new UploadParkingFile().createParkingUsingfileInput(args[0]);
		}else {
			PrintUtils.log("Usage : java -cp <jarname> <filepath>");
		}
		
	}
}
