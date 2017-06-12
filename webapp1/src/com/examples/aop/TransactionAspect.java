package com.examples.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class TransactionAspect {
	public int check(ProceedingJoinPoint pjp, int force) {
		System.out.println("Before slowing: " + force);
		
		try {
			int fr = (int) pjp.proceed();
			System.out.println(fr);	
			if (fr < 0) {
				return 0;
			}
			return fr;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
		System.out.println("After slowing: " + force);

		return 100;
	}
}
