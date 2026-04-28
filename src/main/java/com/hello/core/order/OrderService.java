package com.hello.core.order;

public interface OrderService{

    //주문 생성. 회원 Id, 상품명, 상품 가격을 넘겨야 한다.
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
