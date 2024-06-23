package com.builder;

public class HouseMain {

	public static void main(String[] args) {
	
		
		House kirti = new House.Builder().setHouseNumber(0).setHomeName("kirti house").setHomeAddress("pune")
				.setParking("need 2 slots atleast").setSwimmingPool("yes").setWatchman("yes").build();
		
		House prasanth = new House.Builder().setHouseNumber(1).setHomeName("prasanth house").setHomeAddress("chennai")
				.setParking("one parking slot is enough").build();
		
		System.out.println(kirti);
		
		System.out.println(prasanth);

	}

}
