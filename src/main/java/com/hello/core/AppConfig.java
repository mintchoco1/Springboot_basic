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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration //설정 정보 담당
public class AppConfig {

    @Bean //이 객체를 스프링 빈으로 등록한다는 뜻
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    /**
     * 실행 순서
     * 1. memberRepository() 호출
     * 2. new MemoryMemberRepository() 생성
     * 3. new MemberServiceImpl(memberRepository()) 실행\
     * 즉, MemberServiceImpl에 MemoryMemberRepository 연결
     */

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    /***
     * 여기서 부터는 생성자부터 봐야함.
     * OrderServiceImpl 객체를 만들 때 반드시 2개의 객체를 같이 줘야한다는 뜻
     * 1. memberRepository() 호출
     * 2. MemoryMemberRepository() 객체 호출
     * 3. discountPolicy() 호출하고 실행. RateDiscountPolicy 객체 생성
     * 4. 이제 new OrderServiceImpl(객체A, 객체B) 실행
     * 5. 이제 OrderServiceImpl 생성자로 들어가보면 매개변수 안에는 객체 A,B가 들어가있음
     */
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //이제 할인 정책 바꿈 -> Rate로
    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
