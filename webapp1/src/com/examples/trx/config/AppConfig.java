package com.examples.trx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"com.examples.trx.dao", "com.examples.trx.service"})
public class AppConfig {

}
