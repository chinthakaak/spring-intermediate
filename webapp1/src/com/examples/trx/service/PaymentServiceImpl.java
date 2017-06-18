package com.examples.trx.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.examples.trx.dao.PaymentDao;
import com.examples.trx.dao.PaymentDaoDeclarativeTrxMgt;
import com.examples.trx.dao.PaymentDaoProgramaticTrxMgt;

@Service
public class PaymentServiceImpl extends PaymentService {
	// For jdbc only trx - non managed
	@Autowired
	private PaymentDao paymentDao;
	
	// For programatic trx management
	@Autowired
	private PaymentDaoProgramaticTrxMgt paymentDaoProgramaticTrxMgt;
	
	@Autowired
	private PlatformTransactionManager platformTransactionManager;
	
	// For declarative transaction management
	@Autowired
	private PaymentDaoDeclarativeTrxMgt paymentDaoDeclarativeTrxMgt;

	@Transactional(propagation = Propagation.REQUIRED) // Propagation.REQUIRED is the default of @Transactional
	public void payWithDeclarativeTrxMgt(int payerAccountNumber, int payeeAccountNumber, int amount) {

			// updateAccount(payerAccountNumber, -amount)
			paymentDaoDeclarativeTrxMgt.updateAccount(payerAccountNumber, -amount);

//			// updateAccount(payeeAccountNumber, +amount)
			paymentDaoDeclarativeTrxMgt.updateAccount(payeeAccountNumber, amount);		
//			
//			// createAccountChangeEntry(payerAccountNumber,+,amount);
			paymentDaoDeclarativeTrxMgt.createAccountChangeEntry(payerAccountNumber, "-", amount);
//			
//			// createAccountChangeEntry(payeeAccountNumber,-,amount);
			paymentDaoDeclarativeTrxMgt.createAccountChangeEntry(payeeAccountNumber, "+", amount);
	
	}
	
	
	public void payWithPrgramaticTrxMgt(int payerAccountNumber, int payeeAccountNumber, int amount) {
		TransactionStatus status = null;
		try {
			TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
			status = platformTransactionManager.getTransaction(transactionDefinition);
			
			// updateAccount(payerAccountNumber, -amount)
			paymentDaoProgramaticTrxMgt.updateAccount(payerAccountNumber, -amount);

//			// updateAccount(payeeAccountNumber, +amount)
			paymentDaoProgramaticTrxMgt.updateAccount(payeeAccountNumber, amount);		
//			
//			// createAccountChangeEntry(payerAccountNumber,+,amount);
			paymentDaoProgramaticTrxMgt.createAccountChangeEntry(payerAccountNumber, "-", amount);
//			
//			// createAccountChangeEntry(payeeAccountNumber,-,amount);
			paymentDaoProgramaticTrxMgt.createAccountChangeEntry(payeeAccountNumber, "+", amount);
			
			platformTransactionManager.commit(status);	
		} catch (Exception e) {
			e.printStackTrace();

			try {
				platformTransactionManager.rollback(status);

			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}

	}
	
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
	
	public void payJdbc(int payerAccountNumber, int payeeAccountNumber, int amount) {			
			paymentDao.updateAccountsAndCreateAccountChangeEntryJdbc(payerAccountNumber, payeeAccountNumber, amount);
						
	}
}
