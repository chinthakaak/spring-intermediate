package com.examples.trx.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.examples.trx.config.AppConfig;

public class PaymentServiceImplTest {
	@Test
	public void payWithoutSpringTransaction() {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		PaymentService paymentService = context.getBean(PaymentService.class);
		paymentService.payJdbc(1, 2, 250);		
	}
}
