package com.hello.core.order;

import com.hello.core.discount.DiscountPolicy;
import com.hello.core.discount.FixDiscountPolicy;
import com.hello.core.discount.RateDiscountPolicy;
import com.hello.core.member.Member;
import com.hello.core.member.MemberRepository;
import com.hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();//회원 찾기
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();//고정 할인 정책(바꾸기 전)
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();//이걸로 바꿔준다.바꾸는 순간 전체를 변경해야함

    //인터페이스에만 의존
    //하지만 구현체가 없는데 어떻게 코드를 실행할 수 있을까?
    //누군가가 클라이언트인 OrderServiceImpl에 DiscountPolicy의 구현 객체를 대신 생성하고 주입해줘야함
    private DiscountPolicy discountPolicy;

    //오더서비스는 두개가 필요
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);//멤버 찾기
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
