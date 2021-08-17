package br.com.demo.db2.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {

	@Autowired
	private Environment env;

	public DataSourceConfig(Environment env) {
		this.env = env;
	}
	
	@Bean
	DataSource dataSource() {
//		Integer maxPoolSize = Integer.parseInt(env.getProperty(""));
		HikariDataSource dataSource = new HikariDataSource();
		
		dataSource.setJdbcUrl(env.getProperty("api.jdbc.url"));
		dataSource.setDriverClassName(env.getProperty("api.jdbc.driver"));
		dataSource.setUsername(env.getProperty("api.jdbc.user"));
		dataSource.setPassword(env.getProperty("api.jdbc.password"));
		
//		dataSource.setConnectionTestQuery(env.getProperty("api.jdbc.test"));
//		dataSource.setMaximumPoolSize(maxPoolSize);
		
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource, false);
	}
	
	
}
