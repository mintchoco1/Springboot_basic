package com.hello.core;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import com.hello.core.member.MemberService;
import com.hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();

        /**MemberService memberService = new MemberServiceImpl();
         * 기존에는 메인에서 직접 MemberServiceImpl을 생성해줬었음
         */
        //memberservice 안에는 memberserviceimpl이 들어가있음
        //appconfig에 memberservice를 달라고 하면 impl 객체를 생성하면서 메모리멤버리포지토리를 쓸거라고 알려줌
        MemberService memberService = appConfig.memberService();
        Member member = new Member("memberA", 1L, Grade.Vip);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("findmember = " + findMember.getName());
        System.out.println("member = " + member.getName());
    }
}
