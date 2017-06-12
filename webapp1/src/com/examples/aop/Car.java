package com.examples.aop;

public class Car {
	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public void drive() {
		System.out.println("Driving ...");
	}
	
	public void throttle(int amount) throws Exception{
		if (amount > 100) {
			System.out.println("High throttling..");
			throw new Exception();
		} else {
			System.out.println("Normal operation");
		}
	}
}