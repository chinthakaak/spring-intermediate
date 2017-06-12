package com.examples.aop;

public class LoggingAspect {
	public void logDriveBefore() {
		System.out.println("Before: logging drive..");
	}
	
	public void logDriveAfter() {
		System.out.println("After: logging drive..");
	}
	
	public void logDriveReturn() {
		System.out.println("Return successfully");
	}
}
