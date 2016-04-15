package xpadro.thymeleaf.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import xpadro.thymeleaf.model.Guest;

@Repository
public interface GuestRepository extends PagingAndSortingRepository<Guest, Long> {
	Page<Guest> findBySurname(String surname,Pageable pageable);
}
