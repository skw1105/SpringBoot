package com.utopia.springboot.controller;

import com.utopia.springboot.controller.dto.PostsResponseDto;
import com.utopia.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;

    @GetMapping("/") // Mustache 에 의해 문자열 반환 시 "src/main/resources/templates"가 앞에 붙고, ".mustache"가 뒤에 붙음
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());

        return "index"; // src/main/resources/templates/index.mustache 로 전환되어 View Resolver가 처리하게 됨.
    }

    @GetMapping("/posts/save")
    public String postSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
