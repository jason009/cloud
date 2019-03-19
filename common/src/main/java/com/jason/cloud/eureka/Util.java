package com.jason.cloud.eureka;

import java.util.HashMap;
import java.util.Map;

public class Util {
    private final static Map<Integer, Item> ITEM_MAP = new HashMap();

    static {
        ITEM_MAP.put(1, new Item(1, "a"));
        ITEM_MAP.put(2, new Item(2, "b"));
        ITEM_MAP.put(3, new Item(3, "c"));
    }

    public static Item getItem(Integer id) {
        return ITEM_MAP.get(id);
    }
}
