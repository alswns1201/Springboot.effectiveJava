package com.java.effective.study.web.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

//lombok에서 지원해주는 getter setter 및 생성자 자동 생성.
@Getter
@RequiredArgsConstructor // final에 대한 필드만 생성자를 만들어준다.
public class HellloResponseDto {

    private final String name;
    private final int amount;

}
