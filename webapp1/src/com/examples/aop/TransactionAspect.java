package com.examples.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class TransactionAspect {
	public void check(ProceedingJoinPoint pjp, int force) {
		System.out.println("Before slowing: " + force);
		
		
		try {
			pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("After slowing: " + force);
	}
}
