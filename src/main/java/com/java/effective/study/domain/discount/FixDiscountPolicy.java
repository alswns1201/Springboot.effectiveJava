package com.java.effective.study.domain.discount;

import com.java.effective.study.domain.member.Grade;
import com.java.effective.study.domain.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixMount = 1000;
    //할인 고정 금액

    @Override
    public int discount(Member member, int price) {
       if(member.getGrade() == Grade.VIP){
           return discountFixMount;
       }else{
           return 0;
       }
    }
}
