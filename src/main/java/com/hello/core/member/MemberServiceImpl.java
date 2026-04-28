package com.hello.core.member;

public class MemberServiceImpl implements MemberService {

    //MemberRepository는 인터페이스에 의존하지만 오른쪽이 문제. DIP 위반
    private final MemberRepository memberRepository;

    /**
     * 생성자를 만들어줌
     * 생성자를 통해서 이 memberRepository의 구현체가 어떤게 들어갈지를 결정
     * **/
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
