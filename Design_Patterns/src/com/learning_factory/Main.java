package com.learning_factory;

public class Main {

	public static void main(String[] args) {
		Notification notification = FactoryMain.getInstance("WhatsApp");
		
		notification.notification();

	}

}
