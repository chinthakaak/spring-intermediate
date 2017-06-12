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
}
