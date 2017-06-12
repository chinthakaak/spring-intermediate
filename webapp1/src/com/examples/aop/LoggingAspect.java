package com.examples.aop;

import org.aspectj.lang.JoinPoint;

public class LoggingAspect {
	public void logThrottleException(JoinPoint joinPoint) {
		System.out.println("High throttling exception..");
		System.out.println("Class: " + joinPoint.getTarget().getClass());
		System.out.println("Sig: " + joinPoint.getSignature());
	}
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
