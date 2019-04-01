package com.jason.cloud.item.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RefreshController {
    @RequestMapping("/refresh2")
    @ResponseBody
    public Object refresh(HttpServletRequest request, @RequestBody(required = false) String s) {
        return new ModelAndView("/actuator/refresh");
    }

    @RequestMapping("/bus-refresh")
    @ResponseBody
    public Object busRefresh(HttpServletRequest request, @RequestBody(required = false) String s) {
        return new ModelAndView("/actuator/bus-refresh");
    }

    @RequestMapping("/bus-refresh2")
    @ResponseBody
    public Object busRefresh2() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://localhost:7080/item-api/actuator/bus-refresh", request, String.class);
        return stringResponseEntity.getBody();
    }
    @RequestMapping("/refresh")
    public Object refresh() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://localhost:7080/item-api/actuator/refresh", request, String.class);
        return stringResponseEntity.getBody();
    }
}
