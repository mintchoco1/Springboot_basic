package com.hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    //자바가 스태틱 영역에 내부적으로 객체를 생성해서 인스턴스에 참조을 넣어둠.조회할 때 얘 사용
    //클래스 밖에서 접근 불가. 객체 생성 없이 사용 가능. 클래스명.변수명 으로 바로 사용 가능
    //instance는 private 이기 때문에 이 클래스 내부에서만 접근 가능. 생성자도 private 이기 때문에 다른 클래스에서 객체 생성 불가능
    //이 함수는 instance를 꺼내부는 창구
    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
    }

    public void logic() {
        System.out.println("SingletonService logic");
    }
}
