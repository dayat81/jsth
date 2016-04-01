package xpadro.thymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xpadro.thymeleaf.model.Person;
import xpadro.thymeleaf.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonRepository personRepository;

	@Autowired
	public PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Transactional
	@Override
	public Page<Person> findAllPageable(Pageable pageable) {
		return personRepository.findAll(pageable);
	}

	@Transactional
	@Override
	public Iterable<Person> save(Iterable<Person> persons) {
		return personRepository.save(persons);
	}

	@Transactional
	@Override
	public void deleteAll(){
		personRepository.deleteAll();
	}
}
