package com.examples.trx.dao;

import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PaymentDaoDeclarativeTrxMgt extends JdbcDaoSupport {
	@Autowired
	public void setDSource(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	@Transactional
	public void updateAccount(int accountNumber, int amount)  {
		Object[] params = {amount, accountNumber};
		int[] types = {Types.NUMERIC, Types.NUMERIC};
//		String sql = "update ACCOUNTS set BALANCE = ? where ACCOUNT_NO = ?";
		String sql = "update ACCOUNTS set BALANCE = BALANCE + ? where ACCOUNT_NO = ?";
//		String sql ="select * from ACCOUNTS";
//		try{
			int row_count = getJdbcTemplate().update(sql, params, types);
//			System.out.println(getJdbcTemplate().queryForList(sql));
			System.out.println(row_count);
//		}catch (DataAccessException accessException){
//			accessException.printStackTrace();
//		}
//		getJdbcTemplate().query(psc, rowMapper)
			try {
				System.out.println(getJdbcTemplate().getDataSource().getConnection());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	@Transactional
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
		
		String sql = "iinsert into ACCOUNT_CHANGES (TIMESTAMP, ACCOUNT_NO, FLAG, AMOUNT)values (? ,? , ?, ?)";
		
		getJdbcTemplate().update(sql, params, types);
	}
}
