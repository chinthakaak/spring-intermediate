package com.examples.trx.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentDao extends JdbcDaoSupport{
	@Autowired
	public void setDSource(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	public void updateAccount(int accountNumber, int amount) {

	}
	
	public void createAccountChangeEntry(int accountNumber, String flag, int amount) {
		
	}
}
