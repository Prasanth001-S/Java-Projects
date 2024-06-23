package com.prototype;

public class FourWheeler extends Vehicle {

	private Boolean isAutomatic;

	private Boolean isDiesal;

	public FourWheeler(String engine, String model, String price, Boolean isAutomatic, Boolean isDiesal) {
		super(engine, model, price);
		this.isAutomatic = isAutomatic;
		this.isDiesal = isDiesal;
	}
	
	protected FourWheeler clone() throws CloneNotSupportedException {
		return (FourWheeler) super.clone();
	}

}
