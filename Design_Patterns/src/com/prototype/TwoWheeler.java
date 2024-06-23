package com.prototype;

public class TwoWheeler extends Vehicle{
	
	private boolean isElectric;

	public TwoWheeler(String engine, String model, String price, boolean isElectric) 
	{
		super(engine, model, price);
		this.isElectric = isElectric;
	}

	protected TwoWheeler clone() throws CloneNotSupportedException {
		return (TwoWheeler) super.clone();
	}
	
	
	
	

}
