package br.com.dkzit.project;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories
public class SpringBootAwsDynamodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAwsDynamodbApplication.class, args);
	}

}
