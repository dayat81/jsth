package xpadro.thymeleaf.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import xpadro.thymeleaf.model.GuestDTO;

public interface GuestService {

	/**
	 * Finds a "page" of persons
	 * 
	 * @param pageable
	 * @return {@link Page} instance
	 */
	Page<GuestDTO> findAllPageable(Pageable pageable);

	/**
	 * Saves collection of persons
	 * 
	 * @param persons
	 * 
	 * @return collection of persons
	 */
	Iterable<GuestDTO> save(Iterable<GuestDTO> persons);
	
	void deleteAll();

}
