package xpadro.thymeleaf.configuration;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xpadro.thymeleaf.model.Person;
import xpadro.thymeleaf.service.PersonService;

@Component
public class DatabaseInitializer {

	private PersonService personService;
	//private GuestService guestService;

	@Autowired
	public DatabaseInitializer(PersonService studentService) {
		this.personService = studentService;
		//this.guestService=gs;
	}

//	@PostConstruct
//	public void populateDatabase() {
//		Person firstPerson = new Person("Barack", "Obama", 40);
//		Person secondPerson = new Person("Vladimir", "Putin", 50);
//		Person thirdPerson = new Person("Jong", "Kim Un", 30);
//		Person fourthPerson = new Person("Angela", "Merkel", 60);
//		Person fifthPerson = new Person("David", "Cameron", 60);
//		Person sixthPerson = new Person(" Alexander", "Lukashenko", 60);
//		personService.deleteAll();
//		//guestService.deleteAll();
//		personService.save(Arrays.asList(firstPerson, secondPerson, thirdPerson, fourthPerson, fifthPerson, sixthPerson));
//	}

}
