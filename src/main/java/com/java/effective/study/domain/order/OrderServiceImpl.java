package com.java.effective.study.domain.order;

import com.java.effective.study.domain.discount.DiscountPolicy;
import com.java.effective.study.domain.member.Member;
import com.java.effective.study.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor // 자동으로 생성자 주입을 해주어 autowired 적용.
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findId(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
