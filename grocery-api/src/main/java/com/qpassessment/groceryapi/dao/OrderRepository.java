package com.qpassessment.groceryapi.dao;

import com.qpassessment.groceryapi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
