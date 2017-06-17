package com.examples.trx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.examples.trx.config.AppConfig;
import com.examples.trx.service.PaymentService;

public class TrxMain {
	public static void main(String[] args) {		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		PaymentService paymentService = context.getBean(PaymentService.class);
		paymentService.pay(1, 2, 190);
	}	
}
