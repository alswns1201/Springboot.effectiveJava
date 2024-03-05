package com.java.effective.study.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {


    @GetMapping("/") // 초기 화면
    public String index(){
        return "index"; // resources/templates/index를 화면에 return
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

}
