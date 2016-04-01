package xpadro.thymeleaf.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import xpadro.thymeleaf.model.Guest;

public interface GuestService {

	/**
	 * Finds a "page" of persons
	 * 
	 * @param pageable
	 * @return {@link Page} instance
	 */
	Page<Guest> findAllPageable(Pageable pageable);

	/**
	 * Saves collection of persons
	 * 
	 * @param persons
	 * 
	 * @return collection of persons
	 */
	Iterable<Guest> save(Iterable<Guest> persons);
	
	void deleteAll();

}
