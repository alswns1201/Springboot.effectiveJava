package com.java.effective.study.domain.order;


import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class Order {

    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discountPrice;



    public int calculatePrice() {
        return itemPrice - discountPrice;
    }

}
