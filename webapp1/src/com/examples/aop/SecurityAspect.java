package com.examples.aop;

public class SecurityAspect {
	public void validate(int doors, int windows) {
		System.out.println("Doors: "+doors);
		System.out.println(("Windows: "+windows));
	}
}
