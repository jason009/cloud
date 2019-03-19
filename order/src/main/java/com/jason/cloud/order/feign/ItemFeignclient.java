package com.jason.cloud.order.feign;

import com.jason.cloud.eureka.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "item-api")
public interface ItemFeignclient {
    @RequestMapping(value = "/item-api/item/{id}", method = RequestMethod.GET)
    Item queryItemById(@PathVariable("id") Integer id);
}
