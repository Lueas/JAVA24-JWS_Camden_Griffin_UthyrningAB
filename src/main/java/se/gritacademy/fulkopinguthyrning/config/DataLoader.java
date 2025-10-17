package se.gritacademy.fulkopinguthyrning.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.gritacademy.fulkopinguthyrning.model.Item;
import se.gritacademy.fulkopinguthyrning.model.Person;
import se.gritacademy.fulkopinguthyrning.repository.ItemRepo;
import se.gritacademy.fulkopinguthyrning.repository.PersonRepo;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private PersonRepo personRepo;

    @Override
    public void run(String... args) throws Exception {
        if (itemRepo.count() == 0) {
            itemRepo.save(new Item(null, "Lawn Mower", "Cuts grass or something."));
            itemRepo.save(new Item(null, "Toaster", "Toasts stuff, for cheap!"));
            itemRepo.save(new Item(null, "Projector", "For watching movies in dull quality."));

        }

        if (personRepo.count() == 0) {
            personRepo.save(new Person(null, "John Doe", "johndoe@example.com"));
            personRepo.save(new Person(null, "Thomas Jefferson", "tomjeffy@example.com"));
            personRepo.save(new Person(null, "Michael Jordan", "michael_jordan4@example.com"));
        }
    }
}