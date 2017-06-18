package com.examples.trx.dao;

import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentDaoDeclarativeTrxMgt extends JdbcDaoSupport {
	@Autowired
	public void setDSource(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	public void updateAccount(int accountNumber, int amount)  {
		Object[] params = {amount, accountNumber};
		int[] types = {Types.NUMERIC, Types.NUMERIC};
//		String sql = "update ACCOUNTS set BALANCE = ? where ACCOUNT_NO = ?";
		String sql = "update ACCOUNTS set BALANCE = BALANCE + ? where ACCOUNT_NO = ?";
//		String sql ="select * from ACCOUNTS";
		try{
			int row_count = getJdbcTemplate().update(sql, params, types);

		}catch (DataAccessException accessException){
			accessException.printStackTrace();
			
			throw accessException;
		}

	}
	public void createAccountChangeEntry(int accountNumber, String flag, int amount) {
		try {
			System.out.println(getJdbcTemplate().getDataSource().getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		java.sql.Date timestamp = new java.sql.Date(new Date().getTime());
//		Date timestamp = new Date();

		Object[] params = {timestamp, accountNumber, flag, amount};
		int[] types = {Types.TIMESTAMP, Types.NUMERIC, Types.VARCHAR, Types.NUMERIC};
		
//		String sql = "insert into ACCOUNT_CHANGES (TIMESTAMP, ACCOUNT_NO, FLAG, AMOUNT)values (? ,? , ?, ?)";
		String sql = "blainsert into ACCOUNT_CHANGES (TIMESTAMP, ACCOUNT_NO, FLAG, AMOUNT)values (? ,? , ?, ?)";
		try {
			getJdbcTemplate().update(sql, params, types);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
