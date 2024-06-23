package com.prototype;

import java.util.HashMap;
import java.util.Map;

public class Registry {
	
	private static Map<String, Vehicle> mapVehicle = new HashMap<>();
	
	static {
		
		mapVehicle.put("Two", new TwoWheeler("two Stock", "2020", "1234", false) );
		mapVehicle.put("Four", new FourWheeler("Four Stock", "2021", "32456", false, false));
		 
	}
	
	public static Vehicle getVehicle(String vehicle) throws CloneNotSupportedException {
		return  mapVehicle.get(vehicle).clone();
	}

}
