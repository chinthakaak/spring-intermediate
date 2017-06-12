package com.examples.aop.annotation;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {
	@Pointcut("execution(* com.examples.aop.annotation.TemperatureSensor.read())")
	public void rd() {
		
	}
	@Before("rd()")
	public void authenticate() {
		System.out.println("Authenticating");
	}
	
	@After("execution(* com.examples.aop.annotation.TemperatureSensor.write(*))")
	public void release() {
		System.out.println("Releaseing");
	}
}
