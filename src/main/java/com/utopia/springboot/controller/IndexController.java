package com.utopia.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/") // Mustache 에 의해 문자열 반환 시 "src/main/resources/templates"가 앞에 붙고, ".mustache"가 뒤에 붙음
    public String index() {
        return "index"; // src/main/resources/templates/index.mustache 로 전환되어 View Resolver가 처리하게 됨.
    }

    @GetMapping("/posts/save")
    public String postSave() {
        return "posts-save";
    }
}
