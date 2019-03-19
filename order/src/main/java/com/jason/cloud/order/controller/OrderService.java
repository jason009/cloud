package com.jason.cloud.order.controller;

import com.jason.cloud.eureka.Item;
import com.jason.cloud.order.feign.ItemFeignclient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private ItemFeignclient itemFeignclient;
    private String url = "http://localhost:7090/item-api/item/";
    @HystrixCommand(fallbackMethod = "query")
    public Item getItem(Integer id) {
        return itemFeignclient.queryItemById(id);
    }
   /* @HystrixCommand(fallbackMethod = "query")
    public Item getItem(Integer id) {
        String service = "ITEM-API";
        String url = "http://" + service + "/item-api/item/";
        System.out.println("url: " + url);
        return restTemplate.getForObject(url + id, Item.class);
    }*/

    public Item query(Integer id) {
        return new Item(0, "查询出错");
    }

     /*
     public Item getItem(@PathVariable Integer id) {
         List<ServiceInstance> serviceInstances = discoveryClient.getInstances("item-api");
         ServiceInstance serviceInstance = serviceInstances.get(0);
         String host = serviceInstance.getHost();
         int port = serviceInstance.getPort();
         String url = "http://" + host + ":" + port + "/item-api/item/";
         System.out.println("url: " + url);
         return restTemplate.getForObject(url + id, Item.class);
     }*/
}
