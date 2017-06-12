package com.examples.aop.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context =  new AnnotationConfigApplicationContext(AppConfig.class);
//		Sensor sensor = (Sensor)context.getBean("temperatureSensor");
		Sensor sensor = (Sensor)context.getBean(Sensor.class);
		System.out.println(sensor.read());
		sensor.write(1);
	}
}
