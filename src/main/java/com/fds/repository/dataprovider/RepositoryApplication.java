package com.fds.repository.dataprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.fds.repository.dataprovider.controller"})
public class RepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepositoryApplication.class, args);
	}

}
