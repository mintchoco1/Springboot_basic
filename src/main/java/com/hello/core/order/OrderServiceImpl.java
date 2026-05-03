package com.hello.core.order;

import com.hello.core.discount.DiscountPolicy;
import com.hello.core.discount.FixDiscountPolicy;
import com.hello.core.discount.RateDiscountPolicy;
import com.hello.core.member.Member;
import com.hello.core.member.MemberRepository;
import com.hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    /*
    private final MemberRepository memberRepository = new MemoryMemberRepository();//회원 찾기
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();//고정 할인 정책(바꾸기 전)
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();//이걸로 바꿔준다.바꾸는 순간 전체를 변경해야함

    //인터페이스에만 의존
    //하지만 구현체가 없는데 어떻게 코드를 실행할 수 있을까?
    //누군가가 클라이언트인 OrderServiceImpl에 DiscountPolicy의 구현 객체를 대신 생성하고 주입해줘야함
    private DiscountPolicy discountPolicy;
    */

    private final MemberRepository memberRepository;
    //OrderServiceImpl은 DisCountPolicy에 의존
    private final DiscountPolicy discountPolicy;

    //여기서 discountpolicy의 구현체를 받는다. 생성자에서 받음
    //MemberRepository와 DiscountPolicy라는 인터페이스 타입을 받음. 이 시점에 괄호 안으로 들어오는게 저장소인지 고정할인지 비율할인지 모름.
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;//던져준 저장소를 받아서 내 주머니에 넣음
        this.discountPolicy = discountPolicy;//던져준 할인 정책을 받아서 내 주머니에 넣음
    }

    //오더서비스는 두개가 필요
    //클라이언트로 부터 누가 무엇을 얼마에 주문했는지 정보를 전달받음
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);//멤버 찾기
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
