package xpadro.thymeleaf.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import xpadro.thymeleaf.model.Person;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

}
