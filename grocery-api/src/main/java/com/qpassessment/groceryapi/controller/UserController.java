package com.qpassessment.groceryapi.controller;

import com.qpassessment.groceryapi.service.ItemService;
import com.qpassessment.groceryapi.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user/groceries")
@AllArgsConstructor
@Slf4j
public class UserController {

    private final ItemService itemService;
    private final OrderService orderService;

    @GetMapping
    public void getItems(){
        log.info("Show items to user");
        itemService.getAllGroceryItems();
    }


    @PostMapping("/{userId}/book-items")
    public ResponseEntity<String> bookItemsInOrder(@PathVariable Integer userId, @RequestBody List<Integer> itemIds) {
        orderService.bookItemsInOrder(userId, itemIds);
        return ResponseEntity.ok("Items booked successfully for user " + userId);
    }
}
