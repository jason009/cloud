package com.jason.cloud.order.controller;

import com.jason.cloud.eureka.Item;
import com.jason.cloud.order.controller.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;


    @GetMapping("/{id}")
    public Item getItem(@PathVariable Integer id) {
        return orderService.getItem(id);
    }
}
