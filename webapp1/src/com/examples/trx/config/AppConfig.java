package com.examples.trx.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ComponentScan(basePackages={"com.examples.trx.dao", "com.examples.trx.service"})
public class AppConfig {	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("company");
		dataSource.setPassword("password");
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager transactionManagerProgramatic() {
		PlatformTransactionManager transactionManager = new DataSourceTransactionManager(dataSource());
		return transactionManager;
	}
	
//	@Bean
//	public DataSourceTransactionManager transactionManagerDeclarative() {
//		return new DataSourceTransactionManager(dataSource());
//	}
}
