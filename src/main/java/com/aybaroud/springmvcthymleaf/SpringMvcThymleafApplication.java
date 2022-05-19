package com.aybaroud.springmvcthymleaf;

import com.aybaroud.springmvcthymleaf.entities.Patient;
import com.aybaroud.springmvcthymleaf.repositories.PatientRepository;
import com.aybaroud.springmvcthymleaf.security.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class SpringMvcThymleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcThymleafApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(PatientRepository patientRepository){
		return args -> {
			patientRepository.save(new Patient(null,"Antoine", new Date(),false,112));
			patientRepository.save(new Patient(null,"Laura", new Date(),true,118));
			patientRepository.save(new Patient(null,"Jack", new Date(),false,214));
		};
	}

	@Bean
	CommandLineRunner saveUsers(SecurityService securityService){
		return args -> {
			securityService.saveNewUser("user1","1234","1234");
			securityService.saveNewUser("user2","1234","1234");
			securityService.saveNewUser("admin","1234","1234");

			securityService.saveNewRole("USER","");
			securityService.saveNewRole("ADMIN","");

			securityService.addRoleToUser("user1","USER");
			securityService.addRoleToUser("user2","USER");
			securityService.addRoleToUser("admin","USER");
			securityService.addRoleToUser("admin","ADMIN");
		};
	}
}
