package com.project.starter;

import javax.sql.DataSource;

import com.project.starter.utils.DatabaseProperties;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class StarterApplication {

	public static void main(String[] args) {
		Flyway flyway = Flyway.configure().dataSource(getFlywayDataSource()).load();
		flyway.migrate();

		SpringApplication.run(StarterApplication.class, args);
	}

	public static DataSource getFlywayDataSource() {
		SingleConnectionDataSource dataSource = new SingleConnectionDataSource(DatabaseProperties.getDatabaseURL(),
				DatabaseProperties.getDatabaseUser(), DatabaseProperties.getDatabasePassword(), true);
		dataSource.setDriverClassName("org.postgresql.Driver");
		return dataSource;
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.project.starter.controllers")).paths(PathSelectors.any())
				.build();
	}

}
