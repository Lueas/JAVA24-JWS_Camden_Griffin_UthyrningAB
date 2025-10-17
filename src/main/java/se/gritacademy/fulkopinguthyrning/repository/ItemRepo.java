package se.gritacademy.fulkopinguthyrning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.gritacademy.fulkopinguthyrning.model.Item;

public interface ItemRepo extends JpaRepository<Item, Long> {
}