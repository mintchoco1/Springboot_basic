package com.hello.core;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import com.hello.core.member.MemberService;
import com.hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member("memberA", 1L, Grade.Vip);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("findmember = " + findMember.getName());
        System.out.println("member = " + member.getName());
    }
}
