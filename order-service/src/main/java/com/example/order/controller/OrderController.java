package com.example.order.controller;

import com.example.order.client.UserClient;
import com.example.order.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {



    @Autowired
    private UserClient userClient;

    // 模拟数据库
    private static final Map<Long, Order> ORDER_DB = new HashMap<>();

    static {
        Order order = new Order();
        order.setId(1L);
        order.setUserId(1L);
        order.setProduct("iPhone 15");
        order.setPrice(6999.0);
        ORDER_DB.put(1L, order);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return ORDER_DB.get(id);
    }

    @GetMapping("/{id}/with-user")
    public Map<String, Object> getOrderWithUser(@PathVariable Long id) {
        Order order = ORDER_DB.get(id);
        Map<String, Object> result = new HashMap<>();
        result.put("order", order);
        result.put("user", userClient.getUser(order.getUserId()));
        return result;
    }
}