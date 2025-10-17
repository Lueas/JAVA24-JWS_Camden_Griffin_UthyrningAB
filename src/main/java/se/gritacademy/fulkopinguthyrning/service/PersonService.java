package se.gritacademy.fulkopinguthyrning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.gritacademy.fulkopinguthyrning.exception.NotFoundException;
import se.gritacademy.fulkopinguthyrning.model.Person;
import se.gritacademy.fulkopinguthyrning.repository.PersonRepo;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepo personRepo;

    public List<Person> getAllPersons() {
        return personRepo.findAll();
    }

    public Person getPersonById(Long id) {
        return personRepo.findById(id).orElseThrow(() -> new NotFoundException("Person not found with id: " + id));
    }

    public Person createPerson(Person person) {
        return personRepo.save(person);
    }

    public void deletePerson(Long id) {
        Person person = getPersonById(id);
        personRepo.delete(person);
    }
}