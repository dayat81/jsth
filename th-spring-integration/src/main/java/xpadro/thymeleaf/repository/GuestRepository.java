package xpadro.thymeleaf.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import xpadro.thymeleaf.model.GuestDTO;

@Repository
public interface GuestRepository extends PagingAndSortingRepository<GuestDTO, Long> {

}
