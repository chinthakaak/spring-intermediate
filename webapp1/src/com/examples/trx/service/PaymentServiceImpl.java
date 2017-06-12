package com.examples.trx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examples.trx.dao.PaymentDao;

@Service
public class PaymentServiceImpl extends PaymentService {
	@Autowired
	private PaymentDao paymentDao;
	
	public void pay(int payerAccountNumber, int payeeAccountnumber, int amount) {
		// updateAccount(payeeAccountNumber, -amount)
		 paymentDao.updateAccount(1, 10);
		
		// updateAccount(payerAccountNumber, +amount)
		
		// createAccountChangeEntry(payeeAccountNumber,-,amount);
		
		// createAccountChangeEntry(payerAccountNumber,+,amount);			
	}
}
