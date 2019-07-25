package com.blog.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;

import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com") })
@EnableJpaRepositories(basePackages = "com.blog.repository")
public class DatabaseConfiguration {

	
	@Bean
	public DriverManagerDataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/blog");
		dataSource.setUsername("root");
		dataSource.setPassword("password");
		return dataSource;

	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(final EntityManagerFactoryBuilder builder) {
		final LocalContainerEntityManagerFactoryBean ret = builder.dataSource(dataSource()).packages("com.health.entity")
				.properties(getVendorProperties()).build();

		return ret;
	}

	protected Map<String, Object> getVendorProperties() {
		HashMap<String, Object> properties = new HashMap<String, Object>();
		// configuration.addAnnotatedClass(Employee.class);
		// properties.put("hibernate.connection.url",
		// "jdbc:p6spy:hsqldb:mem:hibernate" + options);
		// properties.put("hibernate.connection.username", "sa");
		// properties.put("hibernate.connection.password", "");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.connection.pool_size", "10");
		return properties;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}
}