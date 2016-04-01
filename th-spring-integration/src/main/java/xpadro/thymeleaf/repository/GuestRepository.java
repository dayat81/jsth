package xpadro.thymeleaf.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import xpadro.thymeleaf.model.Guest;

@Repository
public interface GuestRepository extends PagingAndSortingRepository<Guest, Long> {

}
