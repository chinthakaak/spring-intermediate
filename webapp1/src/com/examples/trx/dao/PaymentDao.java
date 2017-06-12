package com.examples.trx.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

@Component
public class PaymentDao extends JdbcDaoSupport{
	public void updateAccount(int accountNumber, int amount) {

	}
	
	public void createAccountChangeEntry(int accountNumber, String flag, int amount) {
		
	}
}
