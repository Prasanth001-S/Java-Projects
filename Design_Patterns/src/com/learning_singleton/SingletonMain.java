package com.learning_singleton;

public class SingletonMain {

	public static void main(String[] args) {
		
		Singleton singleTon = Singleton.getCurrentInstance();
		System.out.println(singleTon.hashCode());
		Singleton singleTonTwo = Singleton.getCurrentInstance();
		System.out.println(singleTonTwo.hashCode());

	}

}
