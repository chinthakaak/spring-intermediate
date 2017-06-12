package com.examples.aop.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.examples.aop.annotation")
public class AppConfig {
//	@Bean
//	public TemperatureSensor temperatureSensor() {
//		return new TemperatureSensor();
//	}
//	
//	@Bean
//	public SecurityAspect securityAspect() {
//		return new SecurityAspect();
//	}
}
