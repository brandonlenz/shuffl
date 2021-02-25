package com.brandonalenz.shuffl.application;

import com.brandonalenz.shuffl.application.model.Organization;
import com.brandonalenz.shuffl.application.model.User;
import com.brandonalenz.shuffl.application.repository.OrganizationRepository;
import com.brandonalenz.shuffl.application.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	// TODO: Swap out H2 in-memory DB for a persistent DB.

	private final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	public CommandLineRunner loadDemoData(UserRepository userRepository,
										  OrganizationRepository organizationRepository) {
		return (args) -> {
			log.info("Adding Organization and Users");
			log.info("-------------------------------");
			Organization organization = organizationRepository.save(new Organization("The Company LLC"));

			log.info(userRepository.save(new User("First0", "Last0", organization)).toString());
			log.info(userRepository.save(new User("First1", "Last1", organization)).toString());
			log.info(userRepository.save(new User("First2", "Last2", organization)).toString());
			log.info(userRepository.save(new User("First3", "Last3", organization)).toString());
			log.info(userRepository.save(new User("First4", "Last4", organization)).toString());
			log.info(userRepository.save(new User("First5", "Last5", organization)).toString());
			log.info("Finished adding Organization and Users");
			log.info("");
		};
	}
}
