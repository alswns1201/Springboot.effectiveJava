package com.java.effective.study.web;


import com.java.effective.study.web.dto.HellloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/Dto")
    public HellloResponseDto helloDto(@RequestParam("name")String name, @RequestParam("amount")int amount ){

        return new HellloResponseDto(name,amount);
    }

}
