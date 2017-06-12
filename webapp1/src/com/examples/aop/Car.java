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
	
	public void lock(int doors, int windows) {
		System.out.println("Locking the car ...");
	}
	
	public int slow(int force) {
		System.out.println("Car slowing down ..");
		
		return --force;
	}
}
