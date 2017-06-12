package com.examples.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) throws Exception {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			Car car = context.getBean("car", Car.class);
			//System.out.println(car.getColor());
			// After before after-return advices - logging
			//car.drive();
			
			// after-throwing logging
			//car.throttle(101);
			
			// parameter passing - security
//			car.lock(4, 4);
			
			car.slow(10);
	}
}
