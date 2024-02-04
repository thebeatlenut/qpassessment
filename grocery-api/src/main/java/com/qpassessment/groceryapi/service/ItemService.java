package com.qpassessment.groceryapi.service;

import com.qpassessment.groceryapi.dao.ItemRepository;
import com.qpassessment.groceryapi.model.Item;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void addGroceryItem(Item item) {
        itemRepository.save(item);
    }

    public List<Item> getAllGroceryItems() {
        return itemRepository.findAll();
    }

    public void removeGroceryItem(int itemId) {
        itemRepository.deleteById(itemId);
    }

    public void updateGroceryItem(Item newItem) {
        itemRepository.save(newItem);
    }

    public void manageInventory(int itemId, int quantity) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        item.setQuantity(quantity);
        itemRepository.save(item);
    }
}
