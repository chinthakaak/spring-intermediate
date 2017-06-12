package com.examples.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) throws Exception {
			AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			context.registerShutdownHook();
			Car car = context.getBean("car", Car.class);
			System.out.println(car.getColor());
			car.drive();
			
			car.throttle(101);
	}
}
