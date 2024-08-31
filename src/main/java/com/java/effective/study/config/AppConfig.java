package com.java.effective.study.config;

import com.java.effective.study.domain.discount.DiscountPolicy;
import com.java.effective.study.domain.discount.RateDiscountPolicy;
import com.java.effective.study.domain.member.MemberRepository;
import com.java.effective.study.domain.member.MemberService;
import com.java.effective.study.domain.member.MemberServiceImpl;
import com.java.effective.study.domain.member.MemoryMemberRepository;
import com.java.effective.study.domain.order.OrderService;
import com.java.effective.study.domain.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
