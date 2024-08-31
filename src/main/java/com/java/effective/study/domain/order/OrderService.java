package com.java.effective.study.domain.order;


public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}