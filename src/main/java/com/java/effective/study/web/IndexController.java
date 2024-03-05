package com.java.effective.study.web;

import com.java.effective.study.service.posts.PostService;
import com.java.effective.study.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostService postService;



    @GetMapping("/") // 초기 화면
    public String index(Model model){
        model.addAttribute("posts",postService.findAllDesc());
        return "index"; // resources/templates/index를 화면에 return
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postService.findById(id);
        model.addAttribute("post",dto);
        return "posts-update";
    }


}
