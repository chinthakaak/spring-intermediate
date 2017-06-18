package com.examples.trx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentDao extends JdbcDaoSupport{	
	@Autowired
	public void setDSource(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	public void updateAccount(int accountNumber, int amount) {
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
		
		String sql = "insert into ACCOUNT_CHANGES (TIMESTAMP, ACCOUNT_NO, FLAG, AMOUNT)values (? ,? , ?, ?)";
		
		getJdbcTemplate().update(sql, params, types);
	}	

	public void updateAccountsAndCreateAccountChangeEntryJdbc(int payerAccountNumber, int payeeAccountNumber,
			int amount) {
		String sql1 = "update ACCOUNTS set BALANCE = BALANCE + ? where ACCOUNT_NO = ?";
		String sql2 = "insert into ACCOUNT_CHANGES (TIMESTAMP, ACCOUNT_NO, FLAG, AMOUNT)values (? ,? , ?, ?)";
		java.sql.Date timestamp = new java.sql.Date(new Date().getTime());
		Connection connection = null;

		try{
			connection = getJdbcTemplate().getDataSource().getConnection();
			connection.setAutoCommit(false);
			
			// update
			PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
			preparedStatement1.setInt(1, -amount);
			preparedStatement1.setInt(2, payerAccountNumber);
			preparedStatement1.executeUpdate();
			
			PreparedStatement preparedStatement2 = connection.prepareStatement(sql1);
			preparedStatement2.setInt(1, amount);
			preparedStatement2.setInt(2, payeeAccountNumber);
			preparedStatement2.executeUpdate();
			
			// inserts
			PreparedStatement preparedStatement3 = connection.prepareStatement(sql2);
			preparedStatement3.setDate(1, timestamp);
			preparedStatement3.setInt(2, payerAccountNumber);
			preparedStatement3.setString(3, "-");
			preparedStatement3.setInt(4, amount);
			preparedStatement3.executeUpdate();	
			
			PreparedStatement preparedStatement4 = connection.prepareStatement(sql2);
			preparedStatement4.setDate(1, timestamp);
			preparedStatement4.setInt(2, payeeAccountNumber);
			preparedStatement4.setString(3, "+");
			preparedStatement4.setInt(4, amount);
			preparedStatement4.executeUpdate();	
			
			connection.commit();
			connection.close();
			
		} catch(Exception e) {
			e.printStackTrace();
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}		
	}
}
