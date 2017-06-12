package com.examples.aop;

public interface Vehicle {
	int slow(int force);

	String getColor();

	void drive();

	void throttle(int i) throws Exception;

	void lock(int i, int j);
}
