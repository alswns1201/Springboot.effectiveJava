package com.java.effective.study.web;

import jdk.jshell.Snippet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


//@Runwith는 Junit4 에서 사용되었으며, springboot에서는 기본이 Junit5이고, @ExtendWith를 쓰거나 생략이 가능하다.
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
   public void hello가_리턴되는_함수() throws Exception{

         String hello = "hello";

         mvc.perform(MockMvcRequestBuilders.get("/hello"))
                 .andExpect(MockMvcResultMatchers.status().isOk())
                 .andExpect(MockMvcResultMatchers.content().string(hello));


    }
}