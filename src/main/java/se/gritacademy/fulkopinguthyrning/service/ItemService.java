package se.gritacademy.fulkopinguthyrning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.gritacademy.fulkopinguthyrning.exception.NotFoundException;
import se.gritacademy.fulkopinguthyrning.model.Item;
import se.gritacademy.fulkopinguthyrning.repository.ItemRepo;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepo itemRepo;

    public List<Item> getAllItems() {
        return itemRepo.findAll();
    }

    public Item getItemById(Long id) {
        return itemRepo.findById(id).orElseThrow(() -> new NotFoundException("Item not found with id: " + id));
    }

    public Item createItem(Item item) {
        return itemRepo.save(item);
    }

    public Item updateItem(Long id, Item itemDetails) {
        Item item = getItemById(id); // This also validates that the item exists
        item.setName(itemDetails.getName());
        item.setDescription(itemDetails.getDescription());
        return itemRepo.save(item);
    }

    public void deleteItem(Long id) {
        Item item = getItemById(id);
        itemRepo.delete(item);
    }
}