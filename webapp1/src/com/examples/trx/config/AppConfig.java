package com.examples.trx.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages={"com.examples.trx.dao", "com.examples.trx.service"})
public class AppConfig {	
	@Bean
	public DataSource dataSource() {
		return new DriverManagerDataSource();
	}
}
