package com.jason.cloud.item.controller;

import com.jason.cloud.eureka.Item;
import com.jason.cloud.eureka.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private Config config;

    @GetMapping("/{id}")
    public Item getItem(@PathVariable Integer id) {
        System.out.println(config.getName());
        return Util.getItem(id);
    }
}
