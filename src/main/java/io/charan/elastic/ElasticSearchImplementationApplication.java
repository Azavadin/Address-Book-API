package io.charan.elastic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.charan.elastic.configuration.ElasticConfiguration;

@Configuration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
@ComponentScan
public class ElasticSearchImplementationApplication {
	
	
	@Autowired
	private ElasticConfiguration configuration;	
	
	private static final Logger logger = LoggerFactory.getLogger(ElasticSearchImplementationApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(ElasticSearchImplementationApplication.class, args);
	}
}
