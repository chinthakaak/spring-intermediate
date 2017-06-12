package com.examples.aop.annotation;

import org.springframework.stereotype.Component;

@Component("temperatureSensor")
public class TemperatureSensor implements Sensor {

	@Override
	public int read() {
		System.out.println("Reading..");
		return 0;
	}

	@Override
	public void write(int value) {
		System.out.println("Writing..");
	}

}
