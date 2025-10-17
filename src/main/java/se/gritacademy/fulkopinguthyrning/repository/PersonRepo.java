package se.gritacademy.fulkopinguthyrning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.gritacademy.fulkopinguthyrning.model.Person;

public interface PersonRepo extends JpaRepository<Person, Long> {
}