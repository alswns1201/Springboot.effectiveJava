package com.java.effective.study.web;

import com.java.effective.study.config.auth.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//@Runwith는 Junit4 에서 사용되었으며, springboot에서는 기본이 Junit5이고, @ExtendWith를 쓰거나 생략이 가능하다.
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloController.class
        , excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)})
// WebMvcTest는 스캔 대상에서 CustomOAuth2UserService를 스캔하지 못해서 문제가 발생. SecurityConfig를 제거해야한다.

//@MockBean(JpaMetamodelMappingContext.class)  // Application에 @EnableJpaAuditing 주입 되어 있으면 Jpa관련 bean이 필요함.
// 위어노테이션으로 해도 되지만 config를 따로 만들어서 사용하는것을 권장.
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @WithMockUser(roles = "USER")
   public void hello가_리턴되는_함수() throws Exception{

         String hello = "hello";

         mvc.perform(MockMvcRequestBuilders.get("/hello"))
                 .andExpect(status().isOk())
                 .andExpect(content().string(hello));
    }

    @Test
    @WithMockUser(roles = "USER")
    public void helloDto롬복_테스트() throws Exception{
        String name= "test";
        int amount = 1000;

        mvc.perform(MockMvcRequestBuilders.get("/hello/Dto")
                        .param("name",name)
                        .param("amount",String.valueOf(1000)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }


}