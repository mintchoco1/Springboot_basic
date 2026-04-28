package com.hello.core.member;

public interface MemberService {

    //회원 가입 + 회원 조회 기능
    void join(Member member);
    Member findMember(Long memberId);
}
