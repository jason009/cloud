package com.jason.cloud.eureka;

import java.io.Serializable;


public class Item implements Serializable {
    private static final long serialVersionUID = 3999074065081777624L;
    private Integer id;
    private String name;

    public Item() {
    }

    public Item(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
