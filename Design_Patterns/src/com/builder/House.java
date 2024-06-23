package com.builder;

public class House {
	
	
	private int houseNumber;
	
	private String homeName;
	
	private String homeAddress;
	
	private String parking;
	
	private String swimmingPool;
	
	private String watchman;
	
	
	private House (Builder builder) {
		
		this.houseNumber = builder.houseNumber;
		this.homeName = builder.homeName;
		this.homeAddress = builder.homeAddress;
		this.parking = builder.parking;
		this.swimmingPool = builder.swimmingPool;
		this.watchman = builder.watchman;
		
		
	}
	
	public static class Builder{
		private int houseNumber;
		
		private String homeName;
		
		private String homeAddress;
		
		private String parking;
		
		private String swimmingPool;
		
		private String watchman;

		public Builder setHouseNumber(int houseNumber) {
			this.houseNumber = houseNumber;
			return this;
		}

		public Builder setHomeName(String homeName) {
			this.homeName = homeName;
			return this;
		}

		public Builder setHomeAddress(String homeAddress) {
			this.homeAddress = homeAddress;
			return this;
		}

		public Builder setParking(String parking) {
			this.parking = parking;
			return this;
		}

		public Builder setSwimmingPool(String swimmingPool) {
			this.swimmingPool = swimmingPool;
			return this;
		}

		public Builder setWatchman(String watchman) {
			this.watchman = watchman;
			
			return this;
		}
		
		public House build() {
			return new House(this);
		}
		
		
	}

	@Override
	public String toString() {
		return "House [houseNumber=" + houseNumber + ", homeName=" + homeName + ", homeAddress=" + homeAddress
				+ ", parking=" + parking + ", swimmingPool=" + swimmingPool + ", watchman=" + watchman + "]";
	}

}


