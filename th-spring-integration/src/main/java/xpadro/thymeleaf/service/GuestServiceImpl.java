package xpadro.thymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xpadro.thymeleaf.model.Guest;
import xpadro.thymeleaf.repository.GuestRepository;

@Service
public class GuestServiceImpl implements GuestService {

	private GuestRepository personRepository;

	@Autowired
	public GuestServiceImpl(GuestRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Transactional
	@Override
	public Page<Guest> findAllPageable(Pageable pageable) {
		return personRepository.findAll(pageable);
	}

	@Transactional
	@Override
	public Iterable<Guest> save(Iterable<Guest> persons) {
		return personRepository.save(persons);
	}

	@Transactional
	@Override
	public void deleteAll(){
		personRepository.deleteAll();
	}
}
