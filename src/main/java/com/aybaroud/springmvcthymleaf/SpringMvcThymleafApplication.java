package com.aybaroud.springmvcthymleaf;

import com.aybaroud.springmvcthymleaf.entities.Patient;
import com.aybaroud.springmvcthymleaf.repositories.PatientRepository;
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
			patientRepository.save(new Patient(null,"Antoine", new Date(),false,12));
			patientRepository.save(new Patient(null,"Laura", new Date(),true,18));
			patientRepository.save(new Patient(null,"Jack", new Date(),false,14));

			patientRepository.findAll().forEach(
					p->{
						System.out.println(p.getNom());
					}
			);
		};
	}

}
