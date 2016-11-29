package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(CharacterRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Character("Jack", "Bauer"));
			repository.save(new Character("Chloe", "O'Brian"));
			repository.save(new Character("Kim", "Bauer"));
			repository.save(new Character("David", "Palmer"));
			repository.save(new Character("Michelle", "Dessler"));

			// fetch all customers
			/*log.info("Characters found with findAll():");
			log.info("-------------------------------");
			for (Character character : repository.findAll()) {
				log.info(character.toString());
			}
            log.info("");*/

			// fetch an individual customer by ID
			/*Character character = repository.findOne(1L);
			log.info("Character found with findOne(1L):");
			log.info("--------------------------------");
			log.info(character.toString());
            log.info("");

			// fetch character by last name
			log.info("Character found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			for (Character bauer : repository.findByLastName("Bauer")) {
				log.info(bauer.toString());
			}
            log.info("");*/
		};
	}

}
