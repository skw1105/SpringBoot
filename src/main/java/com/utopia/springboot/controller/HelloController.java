package com.utopia.springboot.controller;

import com.utopia.springboot.dao.HelloResponseDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String HelloWorld() {
        return "Hello World";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dao")
    public HelloResponseDao HelloDao(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDao(name, amount);
    }
}
