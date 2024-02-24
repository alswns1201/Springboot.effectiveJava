package com.java.effective.study.web.dto;


import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*; // assertj의 assertThat() 이용.

class HellloResponseDtoTest {

    @Test
   void 롬복기능_테스트(){
        //given
        String name ="Test";
        int amount = 1000;
        //when
        HellloResponseDto dto = new HellloResponseDto(name,amount);
        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

    }
}