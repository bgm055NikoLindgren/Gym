package com.example.Gym;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.Gym.domain.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.Gym.domain.Exercise;
import com.example.Gym.domain.ExerciseRepository;
import com.example.Gym.domain.Bodypart;
import com.example.Gym.domain.BodypartRepository;
import com.example.Gym.domain.User;

@SpringBootApplication
public class GymApplication {
	private static final Logger log = LoggerFactory.getLogger(GymApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GymApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner ExerciseDemo(ExerciseRepository repository, BodypartRepository crepository, UserRepository userRepository) {
		return (args) -> {
			log.info("save a couple of exercises!");
			
			crepository.save(new Bodypart("Kädet"));
			crepository.save(new Bodypart("Jalat"));
			crepository.save(new Bodypart("Rinta"));
			crepository.save(new Bodypart("Selkä"));
			crepository.save(new Bodypart("Ylävartalo"));
			crepository.save(new Bodypart("Alavartalo"));
			
			
			repository.save(new Exercise("Hauiskääntö", 15, 4, "2 minuuttia", crepository.findBybodypartName("Kädet").get(0)));
			repository.save(new Exercise("Jalkaprässi", 12, 3, "1 minuutti", crepository.findBybodypartName("Jalat").get(0)));
		
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER", "user@gmail.com");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN", "admin@gmail.com");
			userRepository.save(user1);
			userRepository.save(user2);
			
			log.info("fetch all exercises!");
			for (Exercise exercise : repository.findAll()) {
				log.info(exercise.toString());
			}

		};
	}
}
