package com.java.effective.study.domain.discount;

import com.java.effective.study.domain.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);

}
