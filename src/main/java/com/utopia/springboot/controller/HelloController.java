package com.utopia.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
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
}
