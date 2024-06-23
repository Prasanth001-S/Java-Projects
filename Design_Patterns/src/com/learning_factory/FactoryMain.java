package com.learning_factory;

public class FactoryMain {

	private FactoryMain() {
		
	}

	public static Notification getInstance(String channel) {
		if(channel.isBlank() || channel.isEmpty()) {
			return null;
		}
		else if(channel.equals("SMS")) {
			return new SMS();
		}
		else if(channel.equals("Email")) {
			return new Email();
		}
		else if(channel.equals("WhatsApp")) {
			return new WhatsApp();
		}
		return null;
	}
}
