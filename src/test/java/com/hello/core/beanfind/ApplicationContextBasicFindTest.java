package com.hello.core.beanfind;

import com.hello.core.AppConfig;
import com.hello.core.member.MemberService;
import com.hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    /**
     * 컨테이너 이름은 memberService, 타입은 MemberService.class(인터페이스)인 객체를 달라고 요청
     * 반환된 객체가 실제로는 MemberServiceImpl 클래스인지 검증(asserThat)합니다
     * 가장 정석적인 방법
     * */
    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        //인터페이스로 조회
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        //System.out.println("memberService = " + memberService);
        //System.out.println("memberService.getClass() = " + memberService.getClass());
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);//검증
    }


    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);//검증
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByname2(){
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);//검증
    }

    @Test
    @DisplayName("빈 이름으로 조회x")
    void findBeanByNameX(){
        //MemberService memberService = ac.getBean("xxxxxx", MemberService.class);
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("xxxxxx", MemberService.class));
    }
}
