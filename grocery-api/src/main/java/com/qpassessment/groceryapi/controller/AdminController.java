package com.qpassessment.groceryapi.controller;

import com.qpassessment.groceryapi.model.Item;
import com.qpassessment.groceryapi.service.ItemService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/groceries")
@AllArgsConstructor
@Slf4j
public class AdminController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/add-item")
    public ResponseEntity<String> additem(@RequestBody Item item) {
        itemService.addGroceryItem(item);
        return ResponseEntity.ok("Grocery item added successfully");
    }

    @GetMapping("/view-items")
    public ResponseEntity<List<Item>> getAllitems() {
        List<Item> items = itemService.getAllGroceryItems();
        return ResponseEntity.ok(items);
    }

    @DeleteMapping("/remove-item/{itemId}")
    public ResponseEntity<String> removeitem(@PathVariable int itemId) {
        itemService.removeGroceryItem(itemId);
        return ResponseEntity.ok("Grocery item removed successfully");
    }

    @PutMapping("/update-item")
    public ResponseEntity<String> updateitem(@RequestBody Item item) {
        itemService.updateGroceryItem(item);
        return ResponseEntity.ok("Grocery item updated successfully");
    }

    @PutMapping("/manage-inventory/{itemId}")
    public ResponseEntity<String> manageInventory(@PathVariable int itemId, @RequestParam int quantity) {
        itemService.manageInventory(itemId, quantity);
        return ResponseEntity.ok("Inventory managed successfully");
    }
}

