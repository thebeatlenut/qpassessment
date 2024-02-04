package com.qpassessment.groceryapi.service;

import com.qpassessment.groceryapi.dao.ItemRepository;
import com.qpassessment.groceryapi.dao.OrderRepository;
import com.qpassessment.groceryapi.model.Item;
import com.qpassessment.groceryapi.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    public void bookItemsInOrder(Integer userId, List<Integer> itemIds) {
        List<Item> items = itemRepository.findAllById(itemIds);

        Order order = Order.builder()
                .userId(userId)
                .items(items)
                .build();

        orderRepository.save(order);
    }
}
