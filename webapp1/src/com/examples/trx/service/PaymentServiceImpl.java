package com.examples.trx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examples.trx.dao.PaymentDao;

@Service
public class PaymentServiceImpl extends PaymentService {
	@Autowired
	private PaymentDao paymentDao;
	
	public void pay(int payerAccountNumber, int payeeAccountNumber, int amount) {
		// updateAccount(payerAccountNumber, -amount)
		 paymentDao.updateAccount(payerAccountNumber, -amount);

//		// updateAccount(payeeAccountNumber, +amount)
		 paymentDao.updateAccount(payeeAccountNumber, amount);		
//		
//		// createAccountChangeEntry(payerAccountNumber,+,amount);
		 paymentDao.createAccountChangeEntry(payerAccountNumber, "-", amount);
//		
//		// createAccountChangeEntry(payeeAccountNumber,-,amount);
		 paymentDao.createAccountChangeEntry(payeeAccountNumber, "+", amount);
	}
}
