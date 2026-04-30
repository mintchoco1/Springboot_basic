package com.hello.core;

import com.hello.core.discount.DiscountPolicy;
import com.hello.core.discount.FixDiscountPolicy;
import com.hello.core.discount.RateDiscountPolicy;
import com.hello.core.member.MemberService;
import com.hello.core.member.MemberServiceImpl;
import com.hello.core.member.MemoryMemberRepository;
import com.hello.core.order.OrderService;
import com.hello.core.order.OrderServiceImpl;
import org.jspecify.annotations.NonNull;

public class AppConfig {

    //여기서 할당
    //다른 impl 이 정상적으로 작동할 수 있도록 필요한 객체들을 실제로 생성해서 연결해줌
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    //나중에 DB를 바꾸고 싶으면 이 코드만 바꾸면 됨
    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //이제 할인 정책 바꿈 -> Rate로
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
